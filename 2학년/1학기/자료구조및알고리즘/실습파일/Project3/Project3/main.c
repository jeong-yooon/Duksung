#include "main.h"

list_t lists[NUM_LISTS];

node_t* create_node(int data) {
	node_t* node = (node_t*)malloc(sizeof(node_t));
	node->data = data;
	node->next = NULL;
	node->prev = NULL;

	return node;
}
void initialize() {
	// 이 함수의 바디를 수정하세요.
}

int insert(int id, int pos, int data) {
	// 이 함수의 바디를 수정하세요.
	//list_t* lists = (list_t*)malloc(sizeof(list_t)*id);
	node_t* head = (node_t*)malloc(sizeof(node_t));
	node_t* newnode = (node_t*)malloc(sizeof(node_t));
	newnode = create_node(data);
	newnode->data = data;
	node_t* cur = head->next;
	list_t* list = &lists[id];
	head = lists[id].head;
	int i = sizeof(lists[id]);
	/*
	if (head == NULL) {
		head->next = newnode;
		newnode->data = data;
	}
	*/
	if (pos > sizeof(list)) return -1;
	else {
		head = newnode;
		newnode->next = list->head->next;
		list->head->next = newnode;
		return 1;
	}
	free(head);
	free(newnode);
}

int find(int id, int data) {
	// 이 함수의 바디를 수정하세요.
	node_t* head = (node_t*)malloc(sizeof(node_t));
	node_t* cur = head->next;
	list_t* list = &lists[id];
	head = lists[id].head;

	while (cur != NULL) {
		if (cur->data == data) {
			return 1;
		}
		cur = cur->next;
	}
	return -1;
}

int delete(int id, int pos) {
	// 이 함수의 바디를 수정하세요.
	node_t* head = (node_t*)malloc(sizeof(node_t));
	node_t* cur = head->next;
	list_t* list = &lists[id];
	head = lists[id].head;
	node_t* rpos = cur;
	node_t* rdata = rpos->data;
	free(head);

	cur->prev->next = cur->next;
	cur = cur->prev;

	if (sizeof(lists[id]) <= pos) return -1;
	else return 1;
	return 0;
}

int count(int id) {
	// 이 함수의 바디를 수정하세요.
	list_t* head = lists[id].head;
	list_t* count = 0;
	if (head == NULL) return 0;
	else {
		node_t* cur = head;
		while (cur != NULL) {
			cur = cur->next;
			count++;
		}
	}
	return count;
}

void reset(int id) {
	// 이 함수의 바디를 수정하세요.
	node_t* head = (node_t*)malloc(sizeof(node_t));
	head = lists[id].head;
	node_t* target = head;
	node_t* temp = target;
	
	while (target != NULL) {
		temp = temp->next;
		free(target);
		target = temp;
	}
}

void print(int id) {
	// 이 함수의 바디를 수정하세요.
	node_t* next;
	node_t* head = (node_t*)malloc(sizeof(node_t));
	head = lists[id].head;
	node_t* cur;
	if (head == NULL) return -1;
	else {
		cur = head;
		printf("%d ", cur->data);
		while (cur->next != head) {
			cur = cur->next;
			printf("%d ", cur->data);
		}
	}
}

void print_reverse(int id) {
	// 이 함수의 바디를 수정하세요.
	node_t* head = (node_t*)malloc(sizeof(node_t));
	head = lists[id].head;
	node_t* cur;
	if (head == NULL) return -1;
	else {
		cur = head;
		printf("%d ", cur->data);
		while (cur->prev != head) {
			cur = cur->prev;
			printf("%d ", cur->data);
		}
	}
}

int main() {
	char command[30];
	int id, pos, data, res;

	initialize();

	while (1) {
		scanf("%s", command);

		if (!strcmp(command, "insert")) {
			scanf("%d %d %d", &id, &pos, &data);
			res = insert(id, pos, data);
			printf("%d\n", res);
		}
		else if (!strcmp(command, "find")) {
			scanf("%d %d", &id, &data);
			res = find(id, data);
			printf("%d\n", res);
		}
		else if (!strcmp(command, "delete")) {
			scanf("%d %d", &id, &pos);
			res = delete(id, pos);
			printf("%d\n", res);
		}
		else if (!strcmp(command, "count")) {
			scanf("%d", &id);
			res = count(id);
			printf("%d\n", res);
		}
		else if (!strcmp(command, "reset")) {
			scanf("%d", &id);
			reset(id);
		}
		else if (!strcmp(command, "print")) {
			scanf("%d", &id);
			print(id);
		}
		else if (!strcmp(command, "print_reverse")) {
			scanf("%d", &id);
			print_reverse(id);
		}
		else if (!strcmp(command, "exit")) {
			break;
		}
	}

	return 0;
}