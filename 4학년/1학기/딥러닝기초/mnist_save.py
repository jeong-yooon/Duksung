# coding: utf-8
try:
    import urllib.request
except ImportError:
    raise ImportError('You should use Python 3.x')
import os.path
import gzip
import pickle
import os
import numpy as np

url_base = 'http://yann.lecun.com/exdb/mnist/'
key_file = {
    'train_img': 'train-images-idx3-ubyte.gz',
    'train_label': 'train-labels-idx1-ubyte.gz',
    'test_img': 't10k-images-idx3-ubyte.gz',
    'test_label': 't10k-labels-idx1-ubyte.gz',
    # 직접 만든 dataset
    # 'train_img1':'mnist_change_label_final.gz',
    # 'train_label1':'mnist_change_label_final.npy',
    # 'train_img2':'augmentation_xx.npy',
    # 'train_label2': 'augmentation_yy.npy'
    'train_img1': 'x_train_3d_test.gz',
    'train_label1': 'y_train_3d_test.gz',
    'train_img2': 'data_x.gz',
    'train_label2': 'data_y.gz'
}

dataset_dir = os.path.dirname(os.path.abspath(__file__))
save_file = dataset_dir + "/mnist.pkl"

train_num = 60000  # train_num 조정하기
test_num = 10000
img_dim = (1, 28, 28)
img_size = 784


def _download(file_name):
    file_path = dataset_dir + "/" + file_name

    if os.path.exists(file_path):
        return

    print("Downloading " + file_name + " ... ")
    urllib.request.urlretrieve(url_base + file_name, file_path)
    print("Done")


def download_mnist():
    for v in key_file.values():
        _download(v)


def _load_label(file_name):
    file_path = dataset_dir + "/" + file_name

    print("Converting " + file_name + " to NumPy Array ...")
    with gzip.open(file_path, 'rb') as f:
        labels = np.frombuffer(f.read(), np.uint8, offset=8)
    print("Done")

    return labels


def _load_img(file_name):
    file_path = dataset_dir + "/" + file_name

    print("Converting " + file_name + " to NumPy Array ...")
    with gzip.open(file_path, 'rb') as f:
        data = np.frombuffer(f.read(), np.uint8, offset=16)
    data = data.reshape(-1, img_size)
    print("Done")

    return data


def _load_img_npy(file_name):
    # npy파일을 load하는 함수
    file_path = dataset_dir + "/" + file_name

    print("Converting " + file_name + " to NumPy Array ...")

    with open(file_path, 'rb') as f:
        # data = np.load(file_path)

        # 원래 data 타입이 float32 => mnist 데이터 타입과 같은 uint8로 변경
        # data = data.astype('uint8')
        data = np.frombuffer(f.read(), np.uint8, offset=16)
    data = data.reshape(-1, img_size)
    print("Done")

    return data


def _load_label_npy(file_name):
    file_path = dataset_dir + "/" + file_name

    print("Converting " + file_name + " to NumPy Array ...")

    with open(file_path, 'rb') as f:
        labels = np.load(file_path)

        # 원래 data 타입이 float32 => mnist 데이터 타입과 같은 uint8로 변경
        labels = labels.astype('uint8')

    # npy의 label이 one_hot_label = True형식으로 인코딩되어있으므로, 디코딩시킨다.
    labels = np.argmax(labels, axis=1).reshape(-1, 1)
    labels = np.array(labels).flatten().tolist()

    print("Done")

    return labels


def _load_img_npy2(file_name):
    # npy파일을 load하는 함수
    ########################################## 처음에 npy파일을 불러왔는데, 파일 불러오는 부분에서는 성공하였지만, 이미지가 표현되지 않는 오류가 있었습니다..
    file_path = dataset_dir + "/" + file_name

    print("Converting " + file_name + " to NumPy Array ...")

    with open(file_path, 'rb') as f:
        data = np.load(file_path)

        # 원래 data 타입이 float32 => mnist 데이터 타입과 같은 uint8로 변경
        data = data.astype('uint8')
        # data = np.frombuffer(f.read(), np.uint8, offset=16)
    # data = np.expand_dims(data, axis=1)
    data = data.reshape(-1, img_size)
    print("Done")

    return data


# 안씀
def _load_label_npy2(file_name):
    file_path = dataset_dir + "/" + file_name

    print("Converting " + file_name + " to NumPy Array ...")

    with open(file_path, 'rb') as f:
        labels = np.load(file_path)

        # 원래 data 타입이 float32 => mnist 데이터 타입과 같은 uint8로 변경
        labels = labels.astype('uint8')
        labels = np.array(labels).flatten().tolist()

    # npy의 label이 one_hot_label = True형식으로 인코딩되어있으므로, 디코딩시킨다.
    # labels = np.argmax(labels, axis=1).reshape(-1, 1)

    print("Done")

    return labels


def _convert_numpy():
    dataset = {}

    # 다양한 train_img, train_label 파일을 불러와 합친다.
    train_img_1 = _load_img(key_file['train_img1'])
    train_img_2 = _load_img(key_file['train_img2'])
    train_img_final = np.concatenate([train_img_1, train_img_2])
    dataset['train_img'] = train_img_final

    train_label_1 = _load_label(key_file['train_label1'])
    train_label_2 = _load_label(key_file['train_label2'])
    train_label_final = np.concatenate((train_label_1, train_label_2), axis=0)
    dataset['train_label'] = train_label_final

    # 확인 필요
    print('len(train_img_1)', len(train_img_1))  # 30348
    print('len(train_img_2)', len(train_img_2))  # 70000
    # print('train_img_1', train_img_1)
    # print('train_img_2', train_img_2)
    print('len(train_img_final)', len(train_img_final))  # 100348
    print('train_img_final', train_img_final)

    print('len(train_label_1)', len(train_label_1))  # 10116
    print('len(train_label_2)', len(train_label_2))  # 70000
    # print('train_label_1', train_label_1)
    # print('train_label_2', train_label_2)
    print('len(train_label_final)', len(train_label_final))  # 80116
    print('train_label_final', train_label_final)
    print(dataset['train_label'])

    dataset['test_img'] = _load_img(key_file['test_img'])
    dataset['test_label'] = _load_label(key_file['test_label'])
    # print('test_label', dataset['test_label'])

    """
    print('출력:', train_img_1, train_img_2)

    print('train_img_1: ',train_img_1, train_img_1.shape)

    #print('train_img_2: ', train_img_2, train_img_2.shape)
    print('------: ', _load_npy(key_file['train_img1']))
    print('test_img: ', _load_img(key_file['test_img']))
    print(len(dataset['train_img']))
    print(len(dataset['train_label']))
    print(dataset['train_img'])
    print(dataset['train_label'])
    #dataset['train_img'] = dataset['train_img'] + dataset['train_img1']

    """

    """
    dataset['train_img'] =  _load_img(key_file['train_img'])
    dataset['train_label'] = _load_label(key_file['train_label'])    
    dataset['test_img'] = _load_img(key_file['test_img'])
    dataset['test_label'] = _load_label(key_file['test_label'])

    """

    return dataset


def init_mnist():
    download_mnist()
    dataset = _convert_numpy()
    print("Creating pickle file ...")
    with open(save_file, 'wb') as f:
        pickle.dump(dataset, f, -1)
    print("Done!")


def _change_one_hot_label(X):
    T = np.zeros((X.size, 10))
    for idx, row in enumerate(T):
        row[X[idx]] = 1

    return T


def load_mnist(normalize=True, flatten=True, one_hot_label=False):
    """MNIST 데이터셋 읽기

    Parameters
    ----------
    normalize : 이미지의 픽셀 값을 0.0~1.0 사이의 값으로 정규화할지 정한다.
    one_hot_label :
        one_hot_label이 True면、레이블을 원-핫(one-hot) 배열로 돌려준다.
        one-hot 배열은 예를 들어 [0,0,1,0,0,0,0,0,0,0]처럼 한 원소만 1인 배열이다.
    flatten : 입력 이미지를 1차원 배열로 만들지를 정한다.

    Returns
    -------
    (훈련 이미지, 훈련 레이블), (시험 이미지, 시험 레이블)
    """
    if not os.path.exists(save_file):
        init_mnist()

    with open(save_file, 'rb') as f:
        dataset = pickle.load(f)

    if normalize:
        for key in ('train_img', 'test_img'):
            dataset[key] = dataset[key].astype(np.float32)
            dataset[key] /= 255.0

    if one_hot_label:
        dataset['train_label'] = _change_one_hot_label(dataset['train_label'])
        dataset['test_label'] = _change_one_hot_label(dataset['test_label'])

    if not flatten:
        for key in ('train_img', 'test_img'):
            dataset[key] = dataset[key].reshape(-1, 1, 28, 28)

    return (dataset['train_img'], dataset['train_label']), (dataset['test_img'], dataset['test_label'])


if __name__ == '__main__':
    init_mnist()