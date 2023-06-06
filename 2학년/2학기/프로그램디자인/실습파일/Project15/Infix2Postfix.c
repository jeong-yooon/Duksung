#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#pragma warning (disable:4996)

// 연산자의 우선순위를 반환한다.
int prec(char op)
{
	switch (op) {
	case '(': case ')': return 0;
	case '+': case '-': return 1;
	case '*': case '/': return 2;
	}
	return -1;
}

// 중위 표기 수식 -> 후위 표기 수식
void infix_to_postfix(char exp[])
{
	int i = 0, j = 0;
	char ch, top_op, dest[100], dest_ch;
	int len = strlen(exp);

	Init();                    // 스택 초기화
	for (i = 0; i < len; i++) {
		ch = exp[i];
		// 연산자이면
		switch (ch) {
		case '+': case '-': case '*': case '/': // 연산자
		  // 스택에 있는 연산자의 우선순위가 더 크거나 같으면 출력
			while (!isEmpty() && (prec(ch) <= prec(peek())))
			{
				dest_ch = pop();
				printf("%c", dest_ch);
				dest[j++] = dest_ch;
			}
			push(ch);
			break;
		case '(':    // 왼쪽 괄호
			push(ch);
			break;
		case ')':    // 오른쪽 괄호
			top_op = pop();
			// 왼쪽 괄호를 만날때까지 출력
			while (top_op != '(')
			{
				dest_ch = top_op;
				printf("%c", dest_ch);
				dest[j++] = dest_ch;
				top_op = pop();
			}
			break;
		default:        // 피연산자
			dest_ch = ch;
			printf("%c", dest_ch);
			dest[j++] = dest_ch;
			break;
		}
	}

	while (!isEmpty())    // 스택에 저장된 연산자들 출력
	{
		dest_ch = pop();
		printf("%c", dest_ch);
		dest[j++] = dest_ch;
	}

	dest[j] = NULL;

	strcpy(exp, dest);
}
// 후위 표기 수식 계산 함수
eval(char exp[])
{
	int op1, op2, value, i = 0;
	int len = strlen(exp);  // eval함수 배열의 크기를 구해서 데이터로 출력
	char ch;

	Init();
	for (i = 0; i < len; i++) {
		ch = exp[i];
		if (ch != '+' && ch != '-' && ch != '*' && ch != '/') {
			value = ch - '0';    // 입력이 피연산자이면
			push(value);
		}
		else {    //연산자이면 피연산자를 스택에서 제거
			op2 = pop();
			op1 = pop();
			switch (ch) { //연산을 수행하고 스택에 저장
			case '+': push(op1 + op2); break;
			case '-': push(op1 - op2); break;
			case '*': push(op1 * op2); break;
			case '/': push(op1 / op2); break;
			}
		}
	}
	return pop();
}

int main(void) {

	//Init();
	int a = 0;
	char input[50];
	char *output[50] = {NULL, };
	char *token;
	printf("Infix 형식의 계산식을 입력하세요: ");
	scanf("%s", &input);
	//gets(input);
	printf("\n");
	token = strtok(input, " ");
	while (token != NULL) {
		output[a] = token;
		a++;
		//printf("토큰: %s\n", token);
		token = strtok(NULL, " ");
		
	}
	/*
	for (int i = 0; i < 10; i++)
	{
		if (output[i] != NULL)           // 문자열 포인터 배열의 요소가 NULL이 아닐 때만
			printf("%s\n", output[i]);   // 문자열 포인터 배열에 인덱스로 접근하여 각 문자열 출력
	}
	*/
	printf("Postfix 형식은 ");
	infix_to_postfix(input);
	int result = eval(input);

	/*
	int i = 0;
	int top = -1;
	char temp;
	//입력받은 문자열의 마지막 문자까지 반복
	while (input[i] != '\0') {
		//연산자를 만난 경우
		if (input[i] == '+' || input[i] == '-' || input[i] == '*' || input[i] == '/') {
			switch (input[i]) {
			case '+': case'-':
			{
				if (top == -1) {
					push(input[i]);
					top++;
					break;
				}
				while (top != -1) {
					int temp = pop();
					top--;
					printf("%c", temp);
				}
				push(input[i]);
				top++;
				break;
			}
			case '*': case '/':
			{
				if (top == -1) {
					push(input[i]);
					top++;
					break;
				}
				int temp = pop();
				top--;
				if (temp == '*' || temp == '/')
					printf("%c", temp);
				else {
					push(temp);
					top++;
				}
				push(input[i]);
				top++;
				break;
			}
			}

		}
		//피연산자를 만난 경우
		else
			printf("%c", input[i]);
		i++;
	}
	for (int i = 0; i <= top; i++) {
		printf("%c", pop());
	}
	*/
	printf("\n");
	printf("결과는 %d 입니다\n", result);
	free(input);
	return 0;
}