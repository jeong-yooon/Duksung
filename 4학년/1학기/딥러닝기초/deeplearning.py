import numpy as np

def AND(x1, x2):
	x = np.array([x1, x2])
	w = np.array([0.5,0.5])
	b = -0.7
	tmp = np.sum(w*x) + b
	if tmp <= 0:
		return 0
	else:
		return 1

def NAND(x1, x2):
	x = np.array([x1, x2])
	w = np.array([-0.5,-0.5])
	b = 0.7
	tmp = np.sum(w*x) + b
	if tmp <= 0:
		return 0
	else:
		return 1

def OR(x1, x2):
	x = np.array([x1, x2])
	w = np.array([0.5,0.5])
	b = -0.2
	tmp = np.sum(w*x) + b
	if tmp <= 0:
		return 0
	else:
		return 1

def XOR(x1, x2):
	s1 = NAND(x1, x2)
	s2 = OR(x1, x2)
	y = AND(s1, s2)
	return y

def HA(x1, x2):
	S = XOR(x1, x2)
	C = AND(x1, x2)
	return (S, C)

def FA(x1, x2, x3):
	w1 = XOR(x1, x2)
	w2 = AND(x3, x1)
	w3 = AND(x1, x2)
	S = XOR(w1, x3)
	Cout = OR(w2, w3)
	return (S, Cout)