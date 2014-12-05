struct Engineer {
	const char *title;
};

void Engineer_init(struct Engineer *this) {
	this->title = "Engineer";
}

const char* Engineer_getTitle(struct Engineer *this) {
	return this->title;
}

struct SrEngineer {
	struct Engineer base;
	const char *title;
};

void SrEngineer_init(struct SrEngineer *this) {
	Engineer_init(this);
	this->title = "Sr. Engineer";
}

const char* SrEngineer_getTitle(struct SrEngineer *this) {
	return this->title;
}

struct PrEngineer {
	struct Engineer base;
	const char *title;
};

void PrEngineer_init(struct PrEngineer *this) {
	Engineer_init(this);
	this->title = "Pr. Engineer";
}

const char* PrEngineer_getTitle(struct PrEngineer *this) {
	return this->title;
}

#include <stdio.h>
int main(int argc, char *argv[]) {
	struct Engineer eng;
	Engineer_init(&eng);
	printf("%s\n", Engineer_getTitle(&eng));
	struct SrEngineer sr;
	SrEngineer_init(&sr);
	printf("%s\n", SrEngineer_getTitle(&sr));
	struct PrEngineer pr;
	PrEngineer_init(&pr);
	printf("%s\n", PrEngineer_getTitle(&pr));

	struct Engineer *engp = &eng;
	printf("%s\n", Engineer_getTitle(&eng));
	engp = &sr;
	printf("%s\n", Engineer_getTitle(&eng));
	engp = &pr;
	printf("%s\n", Engineer_getTitle(&eng));

	return 0;
}