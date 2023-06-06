#include <Windows.h>
#include<stdio.h>
#include<GL/GLUT.H>
#include<GL/GL.H>
#include<GL/GLU.H>
#pragma warning (disable:4996)

//꼭지점정보 . 삼각형정보를 저장할 배열 변수 선언.
int numV; //꼭짓점 개수, 파일에서 읽어 와야 함. 여기에서는 17668
int numT; //삼각형 개수, 파일에서 읽어 와야 함. 여기에서는 16922

float* vx;
float* vy;
float* vz;

int* a;
int* b;
int* c;

float vx_max = -100000.0f;
float vy_max = -100000.0f;
float vz_max = -100000.0f;

float vx_min = 100000.0f;
float vy_min = 100000.0f;
float vz_min = 100000.0f;

float lmax;
int menu;

GLfloat w, h, tx, ty, sx, sy, sz;

static int Sup = 0, Sdown = 0, Mx = 0, Px = 0, My = 0, Py = 0, Mz = 0, Pz = 0;
static char array[20];

void reshape(int w, int h) {

	glLoadIdentity();
	glViewport(0, 0, w, h);
	glMatrixMode(GL_PROJECTION);
	glLoadIdentity();
	// 카메라 설정

	glOrtho(-1.0, 1.0, -1.0, 1.0, -1.0f, 1.0f);
	//glFrustum(-1.0, 1.0, -1.0, 1.0, -1.0f, 1.0f);
	//gluPerspective(60.0, w/h, 1.0f, 30.0f);

}

void display(void) {

	glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
	glMatrixMode(GL_MODELVIEW);
	glLoadIdentity();

	gluLookAt(0.0f, 0.0f, 0.3f, -(vx_max + vx_min) / 2.0f, -(vy_max + vy_min) / 2.0f , -(vz_max + vz_min) / 2.0f,0.0f, 1.0f, 0.0f); // 카메라 위치 정보

	glPushMatrix();

	// rotate 정보

	glRotatef((float)Mx, 0.0f, 0.0f, 1.0f); //x축
	glRotatef((float)My, 0.0f, 1.0f, 0.0f); //y축
	glRotatef((float)Mz, 1.0f, 0.0f, 0.0f); //z축
	glRotatef((float)Px, 0.0f, 0.0f, 1.0f); //x축
	glRotatef((float)Py, 0.0f, 1.0f, 0.0f); //y축
	glRotatef((float)Pz, 1.0f, 0.0f, 0.0f); //z축

	// scale 정보

	glScalef(1.0f/lmax + (float)sx, 1.0f/lmax + (float)sy, 1.0f/lmax + (float)sz);

	// translate 정보

	glTranslatef(-(vx_max + vx_min) / 2.0f + (float)tx, -(vy_max + vy_min) / 2.0f + (float)ty, -(vz_max + vz_min) / 2.0f); // 중심점

	// light 정보

	//glShadeModel (GL_FLAT);
	//glShadeModel(GL_SMOOTH);
	glEnable(GL_DEPTH_TEST);
	glEnable(GL_LIGHTING);
	glEnable(GL_LIGHT0);

	float position0[4] = { 10.0f, 10.0f, 10.0f, 1.0f };
	float ambient0[4] = { 0.1f, 0.1f, 0.1f, 1.0f };
	float diffuse0[4] = { 0.2f, 0.2f, 0.2f, 1.0f };
	float spectular0[4] = { 0.1f, 0.1f, 0.1f, 1.0f };

	glLightfv(GL_LIGHT0, GL_POSITION, position0);
	glLightfv(GL_LIGHT0, GL_AMBIENT, ambient0);
	glLightfv(GL_LIGHT0, GL_DIFFUSE, diffuse0);
	glLightfv(GL_LIGHT0, GL_SPECULAR, spectular0);

	glColor3f(1.0f, 0.0f, 0.0f);

	//모델배치
	switch (menu) {
	case GL_POINTS:
		glBegin(GL_POINTS);
		for (int i = 0; i < numV; i++) {
			glVertex3f(vx[i], vy[i], vz[i]);
		}
		glEnd();
		break;
	case GL_LINES:
		glBegin(GL_LINES);
		for (int i = 0; i < numV; i++) {
			glVertex3f(vx[i], vy[i], vz[i]);
		}
		glEnd();
		break;
	case GL_TRIANGLES:
		glBegin(GL_TRIANGLES);
		for (int i = 0; i < numT; i++) {
			glVertex3f(vx[a[i]], vy[a[i]], vz[a[i]]);
			glVertex3f(vx[b[i]], vy[b[i]], vz[b[i]]);
			glVertex3f(vx[c[i]], vy[c[i]], vz[c[i]]);
		}
		glEnd();
		break;
	}
	glPopMatrix();
	glFlush();
	glutSwapBuffers();

}

void keyboard(unsigned char key, int x, int y) {

	switch (key) {
	case '1': //vertex
		menu = GL_POINTS;
		glutPostRedisplay();
		break;
	case '2': //wireframe
		menu = GL_LINES;
		glutPostRedisplay();
		break;
	case '3': //solid mesh (face)
		menu = GL_TRIANGLES;
		glutPostRedisplay();
		break;
	case 'f': // frat shading
		glShadeModel(GL_FLAT);
		glutPostRedisplay();
		break;
	case 'v': // smooth(gouraud) shading
		glShadeModel(GL_SMOOTH);
		glutPostRedisplay();
		break;
	case '4': // orthographic view
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(-1.0, 1.0, -1.0, 1.0, -1.0f, 1.0f);
		glutPostRedisplay();
		break;
	case '5': // perspecttive view
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		gluPerspective(170.0, (GLfloat)w / (GLfloat)h, 1.0, 10000.0);
		glutPostRedisplay();
		break;
	case '6': // frustum view
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glFrustum(-1.0, 1.0, -1.0, 1.0, -1.0f, 1.0f);
		glutPostRedisplay();
		break;
	case 'w': // up
		ty = ty + 1.0f;
		glutPostRedisplay();
		break;
	case 's': // down
		ty = ty - 1.0f;
		glutPostRedisplay();
		break;
	case 'a': // left
		tx = tx - 1.0f;
		glutPostRedisplay();
		break;
	case 'd': // right
		tx = tx + 1.0f;
		glutPostRedisplay();
		break;
	case '+': // scale up
		sx = sx + 0.01f;
		sy = sy + 0.01f;
		sz = sz + 0.01f;
		glutPostRedisplay();
		break;
	case '-': // scale down
		sx = sx - 0.01f;
		sy = sy - 0.01f;
		sz = sz - 0.01f;
		glutPostRedisplay();
		break;
	case 'y': // -x
		Mx = (Mx - 10) % 360;
		glutPostRedisplay();
		break;
	case 'b': // +x
		Px = (Px + 10) % 360;
		glutPostRedisplay();
		break;
	case 'g': // -y
		My = (My - 10) % 360;
		glutPostRedisplay();
		break;
	case 'h': // +y
		Py = (Py + 10) % 360;
		glutPostRedisplay();
		break;
	case 'n': // -z
		Mz = (Mz - 10) % 360;
		glutPostRedisplay();
		break;
	case 'm': // +z
		Pz = (Pz + 10) % 360;
		glutPostRedisplay();
		break;
	default:
		break;
	}
}

int main(int argc, char** argv) {

	//1. off 파일에서 꼭지점 개수와 삼각형 개수 읽어 온다.
	char str[255];
	int dummy;

	FILE* fp = fopen("C:\\what_is_this\\what_is_this3.off", "r");

	fscanf(fp, "%s", str); //첫줄(OFF) 읽고 버리기
	fscanf(fp, "%d %d %d", &numV, &numT, &dummy); //두번째 줄에서 꼭지점 개수, 삼각형 개수, 의미 없는 정보 읽기

	//2. 꼭지점 개수와 삼각형 개수만큼 배열로 메모리 할당
	vx = new float[numV];
	vy = new float[numV];
	vz = new float[numV];

	a = new int[numT];
	b = new int[numT];
	c = new int[numT];

	//3. off파일에서 vertex좌표와 삼각형 정보를 읽어서 전역변수의 배열에 정보 채우기
	//꼭지점 배열 채우기
	int i;

	for (i = 0; i < numV; i++) {
		fscanf(fp, "%f %f %f", &vx[i], &vy[i], &vz[i]);

		//x,y,z 축 방향으로 꼭지점의 최대 최소값 결정 (바운딩 박스를 잡을 때 사용)
		//원점에서 가장 가까운꼭지점이 min 가장 먼꼭지점이 max
		if (vx[i] > vx_max)
			vx_max = vx[i];

		if (vx[i] < vx_min)
			vx_min = vx[i];

		if (vy[i] > vy_max)
			vy_max = vy[i];

		if (vy[i] < vy_min)
			vy_min = vy[i];

		if (vz[i] > vz_max)
			vz_max = vz[i];

		if (vz[i] < vz_min)
			vz_min = vz[i];
	}

	//삼각형 색인 배열 채우기(a, b, c)
	for (i = 0; i < numT; i++) {
		fscanf(fp, "%d %d %d %d", &dummy, &a[i], &b[i], &c[i]);
	}
	lmax = max(max(vx_max - vx_min, vy_max - vy_min), vz_max - vz_min); //셋 중 가장 큰 값 찾기
	//printf("%f\n", vx[0]); //확인용
	//printf("%d\n", numV); //확인용
	//printf("%d\n", numT);
	//printf("%f", lmax);

	glutInit(&argc, argv);
	glutInitDisplayMode(GLUT_DOUBLE | GLUT_RGB);
	glutInitWindowSize(800, 800);
	glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
	glutCreateWindow("Example");

	glutDisplayFunc(display);
	glutReshapeFunc(reshape);
	glutKeyboardFunc(keyboard); //키보드콜백펑션
	glutMainLoop();

	fclose(fp);
	return 0;
}