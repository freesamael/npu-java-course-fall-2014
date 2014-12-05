struct Point2d {
	int x;
	int y;
};

struct Point3d {
	struct Point2d base;
	int z;
};

#include <stdio.h>
int main(int argc, char *argv[]) {
	struct Point2d p2d;
	p2d.x = 100;
	p2d.y = 50;
	printf("Point2d: x=%d, y=%d\n", p2d.x, p2d.y);

	struct Point3d p3d;
	p3d.base.x = 100;
	p3d.base.y = 50;
	p3d.z = 75;
	printf("Point3d: x=%d, y=%d, z=%d\n", p3d.base.x, p3d.base.y, p3d.z);

	struct Point2d *p2dp = (struct Point2d *)&p3d;
	p2dp->x = 50;
	p2dp->y = 100;
	printf("pointer of Point3d as Point2d: x=%d, y=%d\n", p2dp->x, p2dp->y);

	return 0;
}
