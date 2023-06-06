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

float g_theta[3]; //회전각도 정보

GLfloat w, h, tx, ty, sx, sy, sz;

static int Sup = 0, Sdown = 0, Mx = 0, Px = 0, My = 0, Py = 0, Mz = 0, Pz = 0;
static char Parray[] = "GL_POINTS";

void reshape(int w, int h) {

	glLoadIdentity();
	glViewport(0, 0, w, h);
	glMatrixMode(GL_PROJECTION);
	glLoadIdentity();
	// 카메라 설정

	glOrtho(-lmax, lmax, -lmax, lmax, - 2 * lmax, 2 * lmax);
	//glFrustum(-lmax/2.0, lmax / 2.0, -lmax / 2.0, lmax / 2.0, 1.0, lmax / 2.0);
	//gluPerspective(170.0, (GLfloat)w / (GLfloat)h, 1.0, 10000.0);
	
}

void display(void) {

	glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
	//glViewport(lmax / 2.0, lmax / 2.0, lmax / 2.0, lmax / 2.0);
	glMatrixMode(GL_MODELVIEW);
	glLoadIdentity();

	gluLookAt(2.0 * (vx_max + vx_min), -(vy_max + vy_min) / 2.0, -2.0 * (vz_max + vz_min), -(vx_max + vx_min) / 2.0f, -(vy_max + vy_min) / 2.0f, -(vz_max + vz_min) / 2.0f, 0.0f, 1.0f, 0.0f); // 카메라 위치 정보

	glPushMatrix();
	glPushMatrix();

	// 키보드 정보

	// rotate 정보
	/*
	glRotatef(g_theta[2], 0.0f, 0.0f, 1.0f); //x축
	glRotatef(g_theta[1], 0.0f, 1.0f, 0.0f); //y축
	glRotatef(g_theta[0], 1.0f, 0.0f, 0.0f); //z축
	*/
	glRotatef((float)Px, 0.0f, 0.0f, 1.0f); //x축
	glRotatef((float)Py, 0.0f, 1.0f, 0.0f); //y축
	glRotatef((float)Pz, 1.0f, 0.0f, 0.0f); //z축

	// scale 정보

	glScalef(1.0f / lmax + sx, 1.0f / lmax + sy, 1.0f / lmax + sz);

	// translate 정보

	glTranslatef(-(vx_max + vx_min) / 2.0f, -(vy_max + vy_min) / 2.0f, -(vz_max + vz_min) / 2.0f); // 중심점

	// light 정보

	//glShadeModel (GL_FLAT);
	glShadeModel(GL_SMOOTH);
	glEnable(GL_DEPTH_TEST);
	glEnable(GL_LIGHTING);
	glEnable(GL_LIGHT0);

	float position0[4] = { 1.0f, 1.0f, 1.0f, 1.0f };
	float ambient0[4] = { 0.5f, 0.5f, 0.5f, 1.0f };
	float diffuse0[4] = { 0.5f, 0.5f, 0.5f, 1.0f };
	float spectular0[4] = { 0.5f, 0.5f, 0.5f, 1.0f };

	glLightfv(GL_LIGHT0, GL_POSITION, position0);
	glLightfv(GL_LIGHT0, GL_AMBIENT, ambient0);
	glLightfv(GL_LIGHT0, GL_DIFFUSE, diffuse0);
	glLightfv(GL_LIGHT0, GL_SPECULAR, spectular0);

	glColor3f(1.0f, 0.0f, 0.0f);
	glPopMatrix();

	//모델배치
	glBegin(GL_TRIANGLES);

	for (int Tindex = 0; Tindex < numT; Tindex++) {
		glVertex3f(vx[a[Tindex]] + tx, vy[a[Tindex]] + ty, vz[a[Tindex]]); //1번째 꼭지점
		glVertex3f(vx[b[Tindex]] + tx, vy[b[Tindex]] + ty, vz[b[Tindex]]); //2번째 꼭지점
		glVertex3f(vx[c[Tindex]] + tx, vy[c[Tindex]] + ty, vz[c[Tindex]]); //3번째 꼭지점
	}
	glEnd();
	glPopMatrix();
	glFlush();
	glutSwapBuffers();

}

void keyboard(unsigned char key, int x, int y) {

	switch (key) {
	case '1': // point (default)

		break;
	case '2': // wireframe

		break;
	case '3': // solidmesh
		glutPostRedisplay();
		break;
	case 'f': // frat shading
		glutPostRedisplay();
		break;
	case 'v': // smooth(gouraud) shading
		glutPostRedisplay();
		break;
	case '4': // orthographic view
		glOrtho(-50.0, 50.0, -50.0, 50.0, 1.0, 50.0);
		break;
	case '5': // perspecttive view
		gluPerspective(170.0, (GLfloat)w / (GLfloat)h, 1.0, 10000.0);
		break;
	case '6': // frustum view
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
		sx = sx + 1.0f;
		sy = sy + 1.0f;
		sz = sz + 1.0f;
		glutPostRedisplay();
		break;
	case '-': // scale down
		sx = sx - 1.0f;
		sy = sy - 1.0f;
		sz = sz - 1.0f;
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

	FILE* fp = fopen("C:\\what_is_this\\what_is_this.off", "r");	// 파일선택

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

	g_theta[0] = 0.0f; //x축
	g_theta[1] = 0.0f; //y축
	g_theta[2] = 0.0f; //z축

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