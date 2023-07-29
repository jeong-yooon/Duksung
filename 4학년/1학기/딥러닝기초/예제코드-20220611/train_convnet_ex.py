# coding: utf-8
import sys, os
sys.path.append(os.pardir)  # 부모 디렉터리의 파일을 가져올 수 있도록 설정
import numpy as np
import matplotlib.pyplot as plt
from dataset.mnist import load_mnist
from simple_convnet import SimpleConvNet
from common.trainer import Trainer
import pickle
import _pickle
# 데이터 읽기(MNIST)
(x_train, t_train), (x_test, t_test) = load_mnist(flatten=False)


#데이터 읽기(추가되는 데이터)
with open('testdata3D.pkl', 'rb') as f:
	datasetL = pickle.load(f)
xt_train, tt_train = datasetL

x_train = np.concatenate([x_train, xt_train])
t_train = np.concatenate([t_train, tt_train])

#원하는 범위의 데이터를 학습용으로 사용하고자 할 경우
x_train, t_train = x_train[:10000], t_train[:10000]
#x_test, t_test = xt_train, tt_train   #모든 데이터를 학습용으로 사용하고자 할 경우

max_epochs = 20

network = SimpleConvNet(input_dim=(1,28,28), 
                        conv_param = {'filter_num': 30, 'filter_size': 5, 'pad': 0, 'stride': 1},
                        hidden_size=100, output_size=10, weight_init_std=0.01)
                        
trainer = Trainer(network, x_train, t_train, x_test, t_test,
                  epochs=max_epochs, mini_batch_size=100,
                  optimizer='Adam', optimizer_param={'lr': 0.001},
                  evaluate_sample_num_per_epoch=1000)
trainer.train()

# 매개변수 보존
network.save_params("params.pkl")
print("Saved Network Parameters!")

# 그래프 그리기
markers = {'train': 'o', 'test': 's'}
x = np.arange(max_epochs)
plt.plot(x, trainer.train_acc_list, marker='o', label='train', markevery=2)
plt.plot(x, trainer.test_acc_list, marker='s', label='test', markevery=2)
plt.xlabel("epochs")
plt.ylabel("accuracy")
plt.ylim(0, 1.0)
plt.legend(loc='lower right')
plt.show()