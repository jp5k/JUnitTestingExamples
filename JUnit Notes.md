JUnit Notes
===========

Chapter 1 - Introduction
========================
*	Find problems early on, and to run tests immediately.
*	Achieves stakeholder goals
*	Meets functional requirements
*	Correctly handles corner cases
*	Performance
*	Usability

We remove fear of change.  Deliver reliability and quality.

System hierarchy = a) Unit tests test a single function (fast, but brittle) 
				   b) Aggregate (slower to run, less brittle 
				   c) System testing - longest to run, end-to-end testing

Chapter 2 - Testing Code
========================

Maven has 'surefire' built in, which allows tests to be run out of the box.
mvn clean test      = will run all tests in project
mvn clean package   = will require all tests to pass to complete build.

GIVEN  (preconditions for the test)  What should the world look like when the behaviour happens
WHEN   What is being tested, the behaviour
THEN   What are the changes that happened.  Normally follows a series of assertions.  Post-condition.

Errors and Failures
-------------------
2 Different things which could go wrong - 
1)State of outside world is wrong (i.e. an exception is thrown)
2)Test is wrong (get an assertion error)

Benefit of testing for exceptions ((1) above) is that you can test the corner cases,
also, you get well documented tests (don't get bitrot like you would with Java docs)

FAILURE (Assertion error)		VS 				   ERROR (Exception thrown)
Tried to check a behaviour						   At any point in the test	
An assertion failed								   An exception was thrown
Suggest the code is broker						   Suggests the test is broken	

Tools usually give you the difference between Failure and Errors
 

Chapter 3 - TDD Test Driven Development
=======================================
Costs of code - maintainability, readability, coupling

TESTS ARE CODE, TREAT THEM WITH SAME RESPECT AS CODE

Good Practices
--------------
1) Well Named - forms exectuable documentations, maintenance, readability, 
   Do not use Test1().  This is an anti-pattern.
   Do not use Restock().  Doesn't say what is under test.
   
   We want names like brewingExpressoConsumesBeans(), or shouldRestockBeans()
   
   Use Domain Terminology
   Natural language
   Be descriptive
 
2) Behaviour not Implementation
   Test the public API, NOT private fields.
   Don't reach into class to test private fields.
   Exposing private state results in brittle and hard to maintain tests.
   Make an Assert about the result of an operation.
   You can change the implementation and the test still passes.
   
3) DRY (Don't Repeat Yourself)
   Set up and Tear down code e.g. (e.g. Cafe cafe = new Cafe(); cafe.restockBeans(7);  put this
                                   in Before method)
   Extract common code, to make more maintainable
   
   Avoid Magic Numbers, e.g. 7.  Use constants instead ESPRESSO_BEANS
   
4) Diagnostics
   i.e don't use  assertTrue(order.size() == 1);   This gives no diagnostic info. Instead use:
   assertEquals(1, order.size())  This will give better diagnostic information.
   Define toString() on objects, to give better diagnostics.
   
   Use a message which will be printed on a failing test("Wrong quantity of coffee", 1, order.size())
  
	
@Before  // Before each test method runs
@After   // After each test method runs
@BeforeClass // Before all tests in the class
@AfterClass  // After all tests in the class
   
Hamcrest   
--------
Provides useful matching techniques.  
Matchers can combine multiple matchers (compositional) e.g. a number is 5 or 7   

Uses 'AsertThat' method. Gives much better diagnostic methods,  
// E.g. to check that a Map has a key with "B" in
assertThat(values, Matchers.hasKey("B");
// Or that a list has the number 5 in it
assertThat(numbers, hasItem(5));
// Also allows composites.  Here, allow value, and also have correct beans.
Assert.assertThat(coffee,
				Matchers.hasProperty("beans", Matchers.equalTo(ESPRESSO_BEANS)));
			
			
Chapter 4 - Building Classes from Tests
=======================================

*	Use tests to drive well designed software
*	Write tests before implementation
*	Always implement things when you actually need them, never when you forsee you need them.
*	Incremental production of well designed and well tested code
*	See Leap Year test for how to drive development.  Failing test, then passing test, refactor code.
		
Triangulation - take a few examples, and then try to generalise using these examples.  


Chapter 5 - Dependencies 
========================
A relationship between two components where functionality of one component relies on the other.

Sales reports examples in the code.
We want test isolation (e.g. testanalysis service needs to be tested on its own)
Classes new up dependencies, highly coupled

Dependency Injection - a way of resolving test isolation and high coupling.  
Need to de-couple our components. 
Constructor argument is taken which allows for dependency injection.  This allows, for example,
a SQL database to be used instead of a csvRepository database.



Chapter 6 - Going outside-in
============================
