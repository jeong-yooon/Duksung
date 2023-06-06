#include <stdio.h>
#include <stdlib.h>
#pragma warning(disable:4996)
#define SIZE 10

int main(void) {

	struct person {
		int age;
		int id;
		int gender;
		int salary;
		struct person* next;
	};

	typedef struct person NODE;

	NODE* head;
	NODE* p;

	p = head;

	for (int i = 0; i < SIZE; i++) {

		p = p->next;
		if (i == 4) break;
	}
	p->next = p->next->next;

	free(p);
	free(head);
	return 0;
}