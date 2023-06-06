#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#ifdef _MSC_VER
#pragma warning(disable: 4996)
#endif

typedef struct _node_t {
	int data;
	struct _node_t* left;
	struct _node_t* right;
}node_t;

node_t* create_node(int data) {
	node_t* node = (node_t*)malloc(sizeof(node_t));
	node->data = data;
	node->left = node->right = NULL;

	return node;
}

node_t* root;

void initialize() {
	root = create_node(0);
}

int add(char pos_string[], int data) {

	node_t* node = create_node(data);
	node_t* p = root;
	node_t* c = root;

	int n = strlen(pos_string);

	for (int i = 0; i < n - 1; i++) {

		if (pos_string[i] == 'L') {

			p = c;
			c = c->left;
		}
		if (pos_string[i] == 'R') {

			p = c;
			c = c->right;
		}

	}
	if (pos_string[n - 1] == 'L') {

		p = c;
		if (p == NULL) return -1;
		if (c->left != NULL) return -1;
		c->left = node;

		return 1;
	}
	if (pos_string[n - 1] == 'R') {

		p = c;
		if (p == NULL) return -1;
		if (c->right != NULL) return -1;
		c->right = node;
		return 1;
	}

	else return -1;
}

int delete(char pos_string[]) {

	node_t* p = root;
	node_t* c = root;

	int n = strlen(pos_string);

	for (int i = 0; i < n - 1; i++) {

		if (pos_string[i] == 'L') {

			p = c;
			c = c->left;
			//if (p == NULL) return -1;
		}
		if (pos_string[i] == 'R') {

			p = c;
			c = c->right;
			//if (p == NULL) return -1;
		}

	}
	if (pos_string[n - 1] == 'L') {

		if (c->left != NULL) {
			//p = c;
			//d = c->left;
			c->left = NULL;

			if (p == NULL) return -1;
			//else root = NULL;
			//c = d;
			free(c->left);
			return 1;
		}

		else return -1;
	}
	if (pos_string[n - 1] == 'R') {

		if (c->right != NULL) {
			//p = c;
			//d = c->right;
			c->right = NULL;

			if (p == NULL) return -1;
			//else root = NULL;
			//c = d;
			free(c->right);
			return 1;
		}

		else return -1;
	}

}

void preorder(node_t* node) {

	if (node == NULL) return;
	printf("%d ", node->data);
	preorder(node->left);
	preorder(node->right);

}

void inorder(node_t* node) {

	if (node == NULL) return;
	inorder(node->left);
	printf("%d ", node->data);
	inorder(node->right);

}

void postorder(node_t* node) {

	if (node == NULL) return;
	postorder(node->left);
	postorder(node->right);
	printf("%d ", node->data);

}

int main() {
	char command[30], pos_string[30];
	int data, res;

	initialize();

	while (1) {
		scanf("%s", command);

		if (!strcmp(command, "add")) {
			scanf("%s %d", pos_string, &data);
			res = add(pos_string, data);
			printf("%d\n", res);
		}
		else if (!strcmp(command, "delete")) {
			scanf("%s", pos_string);
			res = delete(pos_string);
			printf("%d\n", res);
		}
		else if (!strcmp(command, "preorder")) {
			preorder(root);
			printf("\n");
		}
		else if (!strcmp(command, "inorder")) {
			inorder(root);
			printf("\n");
		}
		else if (!strcmp(command, "postorder")) {
			postorder(root);
			printf("\n");
		}
		else if (!strcmp(command, "exit")) {
			break;
		}
	}

	return 0;
}