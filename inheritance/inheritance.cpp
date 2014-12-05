class Point2d {
public:
	int x;
	int y;
};

class Point3d : public Point2d {
public:
	int z;
};

#include <cstdio>
int main(int argc, char *argv[]) {
	Point2d p2d;
	p2d.x = 100;
	p2d.y = 50;
	printf("Point2d: x=%d, y=%d\n", p2d.x, p2d.y);

	Point3d p3d;
	p3d.x = 100;
	p3d.y = 50;
	p3d.z = 75;
	printf("Point3d: x=%d, y=%d, z=%d\n", p3d.x, p3d.y, p3d.z);

	Point2d *p2dp = &p3d;
	p2dp->x = 50;
	p2dp->y = 100;
	printf("pointer of Point3d as Point2d: x=%d, y=%d\n", p2dp->x, p2dp->y);

	return 0;
}