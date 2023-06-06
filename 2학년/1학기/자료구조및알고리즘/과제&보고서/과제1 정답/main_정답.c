#include "main.h"

list_t lists[NUM_LISTS];

void initialize() {
	for (int i = 0; i < NUM_LISTS; i++) {
		lists[i].head = NULL;
		lists[i].count = 0;
	}
}

node_t* create_node(int data) {
	node_t* node = (node_t*)malloc(sizeof(node_t));
	node->data = data;
	node->next = NULL;
	node->prev = NULL;

	return node;
}

int insert(int id, int pos, int data) {	
	list_t* list = &lists[id];
	if (pos == -1) pos = list->count;
	if (pos > list->count) return -1;

	node_t* node = create_node(data);

	if (list->head == NULL) {
		list->head = node;
		list->count = 1;
		return 1;
	}

	node_t* p = list->head, * p_prev = NULL;

	while (pos--) {
		p_prev = p;
		p = p->next;
	}

	node->prev = p_prev;
	node->next = p;

	if (p_prev) p_prev->next = node;
	if (p) p->prev = node;

	if (p == list->head) list->head = node;
	list->count++;

	return 1;
}

int find(int id, int data) {
	list_t* list = &lists[id];
	node_t* p = list->head;
	if (p == NULL) return -1;

	int i = 0;

	while (p) {
		if (p->data == data) return i;
		i++;
		p = p->next;
	}

	return -1;
}

int delete(int id, int pos) {
	list_t* list = &lists[id];
	if (pos >= list->count) return -1;
	if (pos == -1) pos = list->count - 1;

	node_t* p = list->head;

	while (pos--) {
		p = p->next;
	}

	//delete p
	node_t* p_prev = p->prev,
		* p_next = p->next;

	if (p_prev) p_prev->next = p_next;
	if (p_next) p_next->prev = p_prev;

	if (p == list->head) list->head = p->next;
	free(p);

	list->count--;
	return 1;
}

int count(int id) {
	return lists[id].count;
}

void reset(int id) {
	list_t* list = &lists[id];
	node_t* p = list->head, * p_next;

	while (p) {
		p_next = p->next;
		free(p);
		p = p_next;
	}

	list->head = NULL;
	list->count = 0;
}

void print(int id) {
	list_t* list = &lists[id];
	node_t* p = list->head;

	while (p) {
		printf("%d ", p->data);
		p = p->next;
	}
	printf("\n");
}

void print_reverse(int id) {
	list_t* list = &lists[id];
	node_t* p = list->head;

	while (p && p->next != NULL) p = p->next;

	while (p) {
		printf("%d ", p->data);
		p = p->prev;
	}
	printf("\n");
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