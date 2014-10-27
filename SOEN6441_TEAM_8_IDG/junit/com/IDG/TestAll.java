package com.IDG;

import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * The class <code>TestAll</code> builds a suite that can be used to run all
 * of the tests within its package as well as within any subpackages of its
 * package.
 * @version Revision:
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
	com.IDG.controller.TestAll.class,
	com.IDG.mapBuilder.TestAll.class,
	com.IDG.mapSimulator.TestAll.class,
})
public class TestAll {

	/**
	 * Launch the test.
	 *
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		JUnitCore.runClasses(new Class[] { TestAll.class });
	}
}
