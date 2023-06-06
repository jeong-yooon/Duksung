#include <stdio.h>
#include <stdlib.h>

#ifdef _MSC_VER
#pragma warning(disable: 4996)
#endif

typedef struct person_t_ {
	int name;
	struct person_t_* next;
} person_t;

person_t* get_new_person(int name) {
	person_t* p = (person_t*)malloc(sizeof(person_t));
	p->name = name;
	p->next = NULL;
	return p;
}
int main() {
	int n, k, i, j;
	scanf("%d %d", &n, &k);

	person_t* head = NULL, *p, *prev = NULL;

	head = get_new_person(1);
	p = head;

	for (i = 2; i <= n; i++) {
		p->next = get_new_person(i);
		p = p->next;
	}
	p->next = head;

	printf("<");
	for (i = 0; i < n - 1; i++) {
		for (j = 0; j < k; j++) {
			prev = p;
			p = p->next;
		}

		//p를 제거합니다.
		printf("%d, ", p->name);
		prev->next = p->next;
		free(p);

		p = prev;
	}
	printf("%d>", p->name);
	free(p);
	
	return 0;
}
