#	Question 1#
A. public abstract class Canine { public Bark speak(); }
#	Question 2#
E. Compilation fails.
( beacause you cant override a final method )
#	Question 3#
A. BD
#	Question 4#
D. None of the above statements will compile.
#	Question 5#
D. Compilation fails.
this is how you fix it : 	
       public static void main(String [] args) {
            int x = 0;
            try {
                 x = thrower();
                 } catch (Exception e) {
                    x++; // this is never called
                  } finally {
                  System.out.println("x = " + ++x);
                         } 
                   } 
this way the answer its going to be : 
B. x = 43; because of the line 20 ++x;                 
#	Question 6#
C. int y = 11; 
because the do{} first executes the code
#	Question 7#   
B. -c;

#	Question 8# 
b) Side Object Tail Side
#	Question 9# 
b)
In Base.foo()
In Derived.bar()
#	Question10# 
The program prints the following: in catch -> in finally ->. 
# Question11#
D. four one three two
# Question12#
class CI12 extends C implements I1, I2 {}

