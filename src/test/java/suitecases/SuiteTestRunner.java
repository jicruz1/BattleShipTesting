package suitecases;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import test.*;



@RunWith(Suite.class)

@Suite.SuiteClasses({
   GameTest.class,
   PlayerTest.class,
   ManagerIOTest.class,
   MenuTest.class,
   MatchTest.class,
   PositionTest.class,
   BoardTest.class
})

public class SuiteTestRunner {   
}  