package S11NamingConventionsL140_151.l148AccessModifiers;

/**
 * Created by dev on 19/11/2015.
 */

// Challenge:
// In the following interface declaration, what is the visibility of:
//
// 1. the Accessible interface?
// 2. the int variable SOME_CONSTANT?
// 3. methodA?
// 4. methodB and methodC?
//
// Hint: think back to the lecture on interfaces before answering.

/*
1. Package: all classes of the packabe
2. Public and Constant
3. Public
4. Public
 */

interface Accessible {
    int SOME_CONSTANT = 100;
    public void methodA();
    void methodB();
    boolean methodC();
}
