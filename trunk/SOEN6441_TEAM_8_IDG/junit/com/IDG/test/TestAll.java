package com.IDG.test;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.IDG.test.ArsenalTest;
import com.IDG.test.GameControllerTest;
import com.IDG.test.GameFileManagerTest;
import com.IDG.test.MapValidityTestCase;
import com.IDG.test.RoomTest;
import com.IDG.test.TestAll;
import com.IDG.test.TowerTest;

/**
 * The class <code>TestAll</code> builds a suite that can be used to run all of
 * the tests within its package as well as within any subpackages of its
 * package.
 * 
 * @author Raman
 * @version $Revision: 1.0 $
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ ArsenalTest.class, GameControllerTest.class,
		GameFileManagerTest.class, MapValidityTestCase.class, RoomTest.class,
		TowerTest.class, StrongEnemyTest.class, SmallEnemyTest.class, EnemyFactoryTest.class,
		EnemyPathTest.class, TowerDistanceTest.class, TowerInfoViewTest.class, MapSimulatorViewTest.class,
		BlockTest.class

})
public class TestAll {
}
