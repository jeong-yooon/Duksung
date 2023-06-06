#include <stdio.h>
#include <string.h>
#include <conio.h>
#define MAX_STACK_SIZE 100
typedef int element;
typedef struct {
    element stack[MAX_STACK_SIZE];
    int top;
} StackType;
char strtmp[100];

void my_get(char* s);

// ���� �ʱ�ȭ �Լ�
void init(StackType* s)
{
    s->top = -1;
}
// ���� ���� ���� �Լ�
int is_empty(StackType* s)
{
    return (s->top == -1);
}
// ��ȭ ���� ���� �Լ�
int is_full(StackType* s)
{
    return (s->top == (MAX_STACK_SIZE - 1));
}
// �����Լ�
void push(StackType* s, element item)
{
    if (is_full(s)) {
        fprintf(stderr, "���� ��ȭ ����\n");
        return;
    }
    else s->stack[++(s->top)] = item;
}
// �����Լ�
element pop(StackType* s)
{
    if (is_empty(s)) {
        fprintf(stderr, "���� ���� ����\n");
    }
    else return s->stack[(s->top)--];
}
// ��ũ�Լ�
element peek(StackType* s)
{
    if (is_empty(s)) {
        fprintf(stderr, "���� ���� ����\n");
    }
    else return s->stack[s->top];
}
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
    StackType s;

    init(&s);                    // ���� �ʱ�ȭ
    for (i = 0; i < len; i++) {
        ch = exp[i];
        // �������̸�
        switch (ch) {
        case '+': case '-': case '*': case '/': // ������
          // ���ÿ� �ִ� �������� �켱������ �� ũ�ų� ������ ���
            while (!is_empty(&s) && (prec(ch) <= prec(peek(&s))))
            {
                dest_ch = pop(&s);
                printf("%c", dest_ch);
                dest[j++] = dest_ch;
            }
            push(&s, ch);
            break;
        case '(':    // ���� ��ȣ
            push(&s, ch);
            break;
        case ')':    // ������ ��ȣ
            top_op = pop(&s);
            // ���� ��ȣ�� ���������� ���
            while (top_op != '(')
            {
                dest_ch = top_op;
                printf("%c", dest_ch);
                dest[j++] = dest_ch;
                top_op = pop(&s);
            }
            break;
        default:        // �ǿ�����
            dest_ch = ch;
            printf("%c", dest_ch);
            dest[j++] = dest_ch;
            break;
        }
    }

    while (!is_empty(&s))    // ���ÿ� ����� �����ڵ� ���
    {
        dest_ch = pop(&s);
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
    StackType s;

    init(&s);
    for (i = 0; i < len; i++) {
        ch = exp[i];
        if (ch != '+' && ch != '-' && ch != '*' && ch != '/') {
            value = ch - '0';    // �Է��� �ǿ������̸�
            push(&s, value);
        }
        else {    //�������̸� �ǿ����ڸ� ���ÿ��� ����
            op2 = pop(&s);
            op1 = pop(&s);
            switch (ch) { //������ �����ϰ� ���ÿ� ����
            case '+': push(&s, op1 + op2); break;
            case '-': push(&s, op1 - op2); break;
            case '*': push(&s, op1 * op2); break;
            case '/': push(&s, op1 / op2); break;
            }
        }
    }
    return pop(&s);
}

void my_get(char strtmp) // ������ �Է¹޴� �Լ�
{
    int i = 0;
    char c;
    while ((c = getchar()) != '\n') {
        if (c == ' ')
            continue;
        else {
            *(strtmp + i) = c;
            i++;
        }
    }
    *(strtmp + i) = '\0';
}

void main()
{
    int result;
    my_get(strtmp);
    infix_to_postfix(strtmp);
    result = eval(strtmp);
    printf("������� %d\n", result);
    getch();
}