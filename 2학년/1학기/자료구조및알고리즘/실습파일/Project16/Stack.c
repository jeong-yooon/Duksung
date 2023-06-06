/*
#define MAX_STACK_SIZE 100
typedef struct Stack {
	char data[100];
	int top;
}s;

void Init() {
	Stack.top = -1;
}

void push(int data) {
	if (isFull()) {
		printf("Stack is full, cannot add element.");
		return;
	}
	Stack.data[++Stack.top] = data;
}

int pop() {
	if (isEmpty()) {
		printf("Stack is full, cannot add element");
		//exit(STACK_EMPTY);
	}
	return Stack.data[Stack.top--];
}

int isFull() {
	if (Stack.top >= MAX_STACK_SIZE - 1) {
		return 1;
	}
	else return 0;
}

int isEmpty() {
	if (Stack.top == -1) {
		return 1;
	}
	else return 0;
}
*/