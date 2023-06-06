#define MAX_QUEUE_SIZE 100
struct Queue {
	char data[100];
	int front;
	int rear;
}Queue;

void InitQ() {
	Queue.front = -1;
	Queue.rear = -1;
	//size = Qsize;
	//queue = (int*)malloc(sizeof(int) * size);
}

void adddQ(int data) {
	if (isFull()) {
		printf("Stack is full, cannot add element.");
		return;
	}
	Queue.data[++Queue.rear] = data;
	return 0;
}

int removeQ() {
	int temp;
	if (isEmpty()) {
		printf("Stack is full, cannot add element");
		return;
		//exit(STACK_EMPTY);
	}
	temp = Queue.data[++Queue.front];
	return temp;
}

int isFullQ() {
	if (Queue.rear == MAX_QUEUE_SIZE - 1) {
		return 1;
	}
	else return 0;
}

int isEmptyQ() {
	if (Queue.front == Queue.rear) {
		return 1;
	}
	else return 0;
}

/*
int queue[MAX_QUEUE_SIZE];
int front, rear;

void Init_queue(void) {
	front = rear = 0;
}
void clear_queue(void) {
	front = rear;
}
int addQ(int k) {
	//큐가 꽉차있는지 확인
	if (isFullQ()) {
		return -1;
	}
	queue[rear] = k;
	rear = ++rear % MAX_QUEUE_SIZE;
}

int removeQ(void) {
	int i;
	if (isEmptyQ()) {
		return -1;
	}

	i = queue[front];
	front = ++front % MAX_QUEUE_SIZE;
	return i;
}

void print_queue(void) {
	int i;
	for (i = front; i != rear; i = ++i % MAX_QUEUE_SIZE)
		printf("%-6d", queue[i]);
}
int isFullQ() {
	if ((rear + 1) % MAX_QUEUE_SIZE == front) {
		return 1;
	}
	else return 0;
}

int isEmptyQ() {
	if (front == rear) {
		return 1;
	}
	else return 0;
}
*/