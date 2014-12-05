struct Engineer {
	const char *title;
	void *(*vtable[1])(void*);
};

const char* Engineer_getTitle(struct Engineer *this);
void Engineer_init(struct Engineer *this) {
	this->title = "Engineer";
	this->vtable[0] = Engineer_getTitle;
}

const char* Engineer_getTitle(struct Engineer *this) {
	return this->title;
}

struct SrEngineer {
	struct Engineer base;
	const char *title;
};

const char* SrEngineer_getTitle(struct Engineer *this);
void SrEngineer_init(struct SrEngineer *this) {
	Engineer_init(this);
	((struct Engineer *)this)->vtable[0] = SrEngineer_getTitle;
	this->title = "Sr. Engineer";
}

const char* SrEngineer_getTitle(struct Engineer *this) {
	return ((struct SrEngineer*)this)->title;
}

struct PrEngineer {
	struct Engineer base;
	const char *title;
};

const char* PrEngineer_getTitle(struct Engineer *this);
void PrEngineer_init(struct PrEngineer *this) {
	Engineer_init(this);
	((struct Engineer *)this)->vtable[0] = PrEngineer_getTitle;
	this->title = "Pr. Engineer";
}

const char* PrEngineer_getTitle(struct Engineer *this) {
	return ((struct PrEngineer*)this)->title;
}

#include <stdio.h>
int main(int argc, char *argv[]) {
	struct Engineer eng;
	Engineer_init(&eng);
	struct SrEngineer sr;
	SrEngineer_init(&sr);
	struct PrEngineer pr;
	PrEngineer_init(&pr);

	struct Engineer *engp = &eng;
	printf("%s\n", ((const char *(*)(struct Engineer *this))engp->vtable[0])(engp));
	engp = &sr;
	printf("%s\n", ((const char *(*)(struct Engineer *this))engp->vtable[0])(engp));
	engp = &pr;
	printf("%s\n", ((const char *(*)(struct Engineer *this))engp->vtable[0])(engp));

	return 0;
}