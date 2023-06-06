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

// 스택 초기화 함수
void init(StackType* s)
{
    s->top = -1;
}
// 공백 상태 검출 함수
int is_empty(StackType* s)
{
    return (s->top == -1);
}
// 포화 상태 검출 함수
int is_full(StackType* s)
{
    return (s->top == (MAX_STACK_SIZE - 1));
}
// 삽입함수
void push(StackType* s, element item)
{
    if (is_full(s)) {
        fprintf(stderr, "스택 포화 에러\n");
        return;
    }
    else s->stack[++(s->top)] = item;
}
// 삭제함수
element pop(StackType* s)
{
    if (is_empty(s)) {
        fprintf(stderr, "스택 공백 에러\n");
    }
    else return s->stack[(s->top)--];
}
// 피크함수
element peek(StackType* s)
{
    if (is_empty(s)) {
        fprintf(stderr, "스택 공백 에러\n");
    }
    else return s->stack[s->top];
}
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
    StackType s;

    init(&s);                    // 스택 초기화
    for (i = 0; i < len; i++) {
        ch = exp[i];
        // 연산자이면
        switch (ch) {
        case '+': case '-': case '*': case '/': // 연산자
          // 스택에 있는 연산자의 우선순위가 더 크거나 같으면 출력
            while (!is_empty(&s) && (prec(ch) <= prec(peek(&s))))
            {
                dest_ch = pop(&s);
                printf("%c", dest_ch);
                dest[j++] = dest_ch;
            }
            push(&s, ch);
            break;
        case '(':    // 왼쪽 괄호
            push(&s, ch);
            break;
        case ')':    // 오른쪽 괄호
            top_op = pop(&s);
            // 왼쪽 괄호를 만날때까지 출력
            while (top_op != '(')
            {
                dest_ch = top_op;
                printf("%c", dest_ch);
                dest[j++] = dest_ch;
                top_op = pop(&s);
            }
            break;
        default:        // 피연산자
            dest_ch = ch;
            printf("%c", dest_ch);
            dest[j++] = dest_ch;
            break;
        }
    }

    while (!is_empty(&s))    // 스택에 저장된 연산자들 출력
    {
        dest_ch = pop(&s);
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
    StackType s;

    init(&s);
    for (i = 0; i < len; i++) {
        ch = exp[i];
        if (ch != '+' && ch != '-' && ch != '*' && ch != '/') {
            value = ch - '0';    // 입력이 피연산자이면
            push(&s, value);
        }
        else {    //연산자이면 피연산자를 스택에서 제거
            op2 = pop(&s);
            op1 = pop(&s);
            switch (ch) { //연산을 수행하고 스택에 저장
            case '+': push(&s, op1 + op2); break;
            case '-': push(&s, op1 - op2); break;
            case '*': push(&s, op1 * op2); break;
            case '/': push(&s, op1 / op2); break;
            }
        }
    }
    return pop(&s);
}

void my_get(char strtmp) // 중위식 입력받는 함수
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
    printf("결과값은 %d\n", result);
    getch();
}