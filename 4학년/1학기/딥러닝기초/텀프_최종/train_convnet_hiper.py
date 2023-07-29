# coding: utf-8
import sys, os
sys.path.append(os.pardir)  # 부모 디렉터리의 파일을 가져올 수 있도록 설정
import numpy as np
import matplotlib.pyplot as plt
from dataset.mnist import load_mnist
from simple_convnet import SimpleConvNet
from common.trainer import Trainer
import pickle
from common.util import shuffle_dataset
# import _pickle
# 데이터 읽기(MNIST)
(x_train, t_train), (x_test, t_test) = load_mnist(flatten=False)


#데이터 읽기(추가되는 데이터)
with open('./dataset/testdata3D_N.pkl', 'rb') as f:
   datasetL = pickle.load(f)
xt_train, tt_train = datasetL

x_train = np.concatenate([x_train, xt_train])
t_train = np.concatenate([t_train, tt_train])

#원하는 범위의 데이터를 학습용으로 사용하고자 할 경우
x_train, t_train = x_train[:5000], t_train[:5000]
#x_test, t_test = xt_train, tt_train   #모든 데이터를 학습용으로 사용하고자 할 경우

# 20%를 검증 데이터로 분할
validation_rate = 0.20
validation_num = int(x_train.shape[0] * validation_rate)
x_train, t_train = shuffle_dataset(x_train, t_train)
x_val = x_train[:validation_num]
t_val = t_train[:validation_num]
x_train = x_train[validation_num:]
t_train = t_train[validation_num:]

max_epochs = 5

def __train(lr, weight_decay, epocs=50):
    network = SimpleConvNet(input_dim=(1,28,28), 
                            conv_param = {'filter_num': 30, 'filter_size': 5, 'pad': 0, 'stride': 1},
                            hidden_size=100, output_size=10, weight_init_std=0.01)
                            
    trainer = Trainer(network, x_train, t_train, x_test, t_test,
                    epochs=max_epochs, mini_batch_size=100,
                    optimizer='adam', optimizer_param={'lr': 0.0001},
                    evaluate_sample_num_per_epoch=1000)
    trainer.train()
    return trainer.test_acc_list, trainer.train_acc_list

# 매개변수 보존
# __train.network.save_params("params.pkl")
# print("Saved Network Parameters!")

# 하이퍼파라미터 무작위 탐색======================================
optimization_trial = 10
results_val = {}
results_train = {}
for _ in range(optimization_trial):
    # 탐색한 하이퍼파라미터의 범위 지정===============
    weight_decay = 10 ** np.random.uniform(-8, -4)
    lr = 10 ** np.random.uniform(-6, -2)
    # ================================================

    val_acc_list, train_acc_list = __train(lr, weight_decay)
    print("val acc:" + str(val_acc_list[-1]) + " | lr:" + str(lr) + ", weight decay:" + str(weight_decay))
    key = "lr:" + str(lr) + ", weight decay:" + str(weight_decay)
    results_val[key] = val_acc_list
    results_train[key] = train_acc_list

# 그래프 그리기========================================================
print("=========== Hyper-Parameter Optimization Result ===========")
graph_draw_num = 20
col_num = 5
row_num = int(np.ceil(graph_draw_num / col_num))
i = 0

for key, val_acc_list in sorted(results_val.items(), key=lambda x:x[1][-1], reverse=True):
    print("Best-" + str(i+1) + "(val acc:" + str(val_acc_list[-1]) + ") | " + key)

    plt.subplot(row_num, col_num, i+1)
    plt.title("Best-" + str(i+1))
    plt.ylim(0.0, 1.0)
    if i % 5: plt.yticks([])
    plt.xticks([])
    x = np.arange(len(val_acc_list))
    plt.plot(x, val_acc_list)
    plt.plot(x, results_train[key], "--")
    i += 1

    if i >= graph_draw_num:
        break

plt.show()

# 그래프 그리기
# markers = {'train': 'o', 'test': 's'}
# x = np.arange(max_epochs)
# plt.plot(x, __train.trainer.train_acc_list, marker='o', label='train', markevery=2)
# plt.plot(x, __train.trainer.test_acc_list, marker='s', label='test', markevery=2)
# plt.xlabel("epochs")
# plt.ylabel("accuracy")
# plt.ylim(0, 1.0)
# plt.legend(loc='lower right')
# plt.show()