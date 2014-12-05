class Engineer {
	const char *title;
public:
	Engineer(): title("Engineer") {}
	virtual const char* getTitle() {
		return title;
	}
};

class SrEngineer : public Engineer {
	const char *title;
public:
	SrEngineer(): title("Sr. Engineer") {}
	const char* getTitle() {
		return title;
	}
};

class PrEngineer : public Engineer {
	const char *title;
public:
	PrEngineer(): title("Pr. Engineer") {}
	const char* getTitle() {
		return title;
	}
};

#include <cstdio>
int main(int argc, char *argv[]) {
	Engineer eng;
	SrEngineer sr;	
	PrEngineer pr;	

	Engineer *engp = &eng;
	printf("%s\n", engp->getTitle());
	engp = &sr;
	printf("%s\n", engp->getTitle());
	engp = &pr;
	printf("%s\n", engp->getTitle());

	return 0;
}