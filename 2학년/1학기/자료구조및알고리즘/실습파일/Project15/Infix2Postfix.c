#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#pragma warning (disable:4996)

// �������� �켱������ ��ȯ�Ѵ�.
int prec(char op)
{
	switch (op) {
	case '(': case ')': return 0;
	case '+': case '-': return 1;
	case '*': case '/': return 2;
	}
	return -1;
}

// ���� ǥ�� ���� -> ���� ǥ�� ����
void infix_to_postfix(char exp[])
{
	int i = 0, j = 0;
	char ch, top_op, dest[100], dest_ch;
	int len = strlen(exp);

	Init();                    // ���� �ʱ�ȭ
	for (i = 0; i < len; i++) {
		ch = exp[i];
		// �������̸�
		switch (ch) {
		case '+': case '-': case '*': case '/': // ������
		  // ���ÿ� �ִ� �������� �켱������ �� ũ�ų� ������ ���
			while (!isEmpty() && (prec(ch) <= prec(peek())))
			{
				dest_ch = pop();
				printf("%c", dest_ch);
				dest[j++] = dest_ch;
			}
			push(ch);
			break;
		case '(':    // ���� ��ȣ
			push(ch);
			break;
		case ')':    // ������ ��ȣ
			top_op = pop();
			// ���� ��ȣ�� ���������� ���
			while (top_op != '(')
			{
				dest_ch = top_op;
				printf("%c", dest_ch);
				dest[j++] = dest_ch;
				top_op = pop();
			}
			break;
		default:        // �ǿ�����
			dest_ch = ch;
			printf("%c", dest_ch);
			dest[j++] = dest_ch;
			break;
		}
	}

	while (!isEmpty())    // ���ÿ� ����� �����ڵ� ���
	{
		dest_ch = pop();
		printf("%c", dest_ch);
		dest[j++] = dest_ch;
	}

	dest[j] = NULL;

	strcpy(exp, dest);
}
// ���� ǥ�� ���� ��� �Լ�
eval(char exp[])
{
	int op1, op2, value, i = 0;
	int len = strlen(exp);  // eval�Լ� �迭�� ũ�⸦ ���ؼ� �����ͷ� ���
	char ch;

	Init();
	for (i = 0; i < len; i++) {
		ch = exp[i];
		if (ch != '+' && ch != '-' && ch != '*' && ch != '/') {
			value = ch - '0';    // �Է��� �ǿ������̸�
			push(value);
		}
		else {    //�������̸� �ǿ����ڸ� ���ÿ��� ����
			op2 = pop();
			op1 = pop();
			switch (ch) { //������ �����ϰ� ���ÿ� ����
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
	printf("Infix ������ ������ �Է��ϼ���: ");
	scanf("%s", &input);
	//gets(input);
	printf("\n");
	token = strtok(input, " ");
	while (token != NULL) {
		output[a] = token;
		a++;
		//printf("��ū: %s\n", token);
		token = strtok(NULL, " ");
		
	}
	/*
	for (int i = 0; i < 10; i++)
	{
		if (output[i] != NULL)           // ���ڿ� ������ �迭�� ��Ұ� NULL�� �ƴ� ����
			printf("%s\n", output[i]);   // ���ڿ� ������ �迭�� �ε����� �����Ͽ� �� ���ڿ� ���
	}
	*/
	printf("Postfix ������ ");
	infix_to_postfix(input);
	int result = eval(input);

	/*
	int i = 0;
	int top = -1;
	char temp;
	//�Է¹��� ���ڿ��� ������ ���ڱ��� �ݺ�
	while (input[i] != '\0') {
		//�����ڸ� ���� ���
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
		//�ǿ����ڸ� ���� ���
		else
			printf("%c", input[i]);
		i++;
	}
	for (int i = 0; i <= top; i++) {
		printf("%c", pop());
	}
	*/
	printf("\n");
	printf("����� %d �Դϴ�\n", result);
	free(input);
	return 0;
}