/**
 * 
 */
package com.IDG.test;

import static org.junit.Assert.*;

import java.awt.Color;
import java.awt.Graphics;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.IDG.mapSimulator.Block;

/**
 * @author wangguan
 *
 */
public class BlockTest {

	Graphics graphics;
	Block block;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		block = new Block();
		block.createId = 'S';
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Check the constructor of the class Block
	 * Test method for {@link com.IDG.mapSimulator.Block#Block()}.
	 */
	@Test
	public void testBlock() {
		assertNotNull(block);
	}

	/**
	 * Test if the createId of a block has been set
	 * Test method for {@link com.IDG.mapSimulator.Block#Block(int, int, int, int, char)}.
	 */
	@Test
	public void testBlockIntIntIntIntChar() {
		assertNotNull(block.createId);
	}
	
	

}
