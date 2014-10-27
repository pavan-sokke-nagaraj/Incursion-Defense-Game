package com.IDG.controller;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>LayoutManagerTest</code> contains tests for the class <code>{@link LayoutManager}</code>.
 *
 * @generatedBy CodePro at 27/10/14 9:06 AM
 * @author Raman
 * @version $Revision: 1.0 $
 */
public class LayoutManagerTest {
	/**
	 * Run the LayoutManager() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 27/10/14 9:06 AM
	 */
	@Test
	public void testLayoutManager_1()
		throws Exception {

		LayoutManager result = new LayoutManager();

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the JMenuBar getMenuBar() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 27/10/14 9:06 AM
	 */
	@Test
	public void testGetMenuBar_1()
		throws Exception {
		LayoutManager fixture = new LayoutManager();
		fixture.fileLoad = new JMenuItem();

		JMenuBar result = fixture.getMenuBar();

		// add additional test code here
		assertNotNull(result);
		assertEquals(false, result.isSelected());
		assertEquals(1, result.getMenuCount());
		assertEquals(true, result.isBorderPainted());
		assertEquals("MenuBarUI", result.getUIClassID());
		assertEquals(true, result.isOpaque());
		assertEquals(null, result.getToolTipText());
		assertEquals(0, result.getWidth());
		assertEquals(0.5f, result.getAlignmentX(), 1.0f);
		assertEquals(0.0f, result.getAlignmentY(), 1.0f);
		assertEquals(false, result.isDoubleBuffered());
		assertEquals(false, result.isValidateRoot());
		assertEquals(0, result.getHeight());
		assertEquals(0, result.getX());
		assertEquals(0, result.getY());
		assertEquals(null, result.getGraphics());
		assertEquals(false, result.requestFocusInWindow());
		assertEquals(false, result.getAutoscrolls());
		assertEquals(null, result.getComponentPopupMenu());
		assertEquals(0, result.getDebugGraphicsOptions());
		assertEquals(false, result.getInheritsPopupMenu());
		assertEquals(null, result.getInputVerifier());
		assertEquals(null, result.getNextFocusableComponent());
		assertEquals(null, result.getRootPane());
		assertEquals(null, result.getTopLevelAncestor());
		assertEquals(null, result.getTransferHandler());
		assertEquals(true, result.getVerifyInputWhenFocusTarget());
		assertEquals(false, result.isManagingFocus());
		assertEquals(true, result.isOptimizedDrawingEnabled());
		assertEquals(false, result.isPaintingForPrint());
		assertEquals(false, result.isPaintingTile());
		assertEquals(true, result.isRequestFocusEnabled());
		assertEquals(false, result.requestDefaultFocus());
		assertEquals(1, result.countComponents());
		assertEquals(1, result.getComponentCount());
		assertEquals(null, result.getFocusTraversalPolicy());
		assertEquals(false, result.isFocusCycleRoot());
		assertEquals(false, result.isFocusTraversalPolicyProvider());
		assertEquals(false, result.isFocusTraversalPolicySet());
		assertEquals("javax.swing.JMenuBar[,0,0,0x0,invalid,layout=javax.swing.plaf.basic.DefaultMenuLayout,alignmentX=0.0,alignmentY=0.0,border=javax.swing.plaf.metal.MetalBorders$MenuBarBorder@54c0968e,flags=424,maximumSize=,minimumSize=,preferredSize=,margin=,paintBorder=true]", result.toString());
		assertEquals(null, result.getName());
		assertEquals(null, result.getParent());
		assertEquals(false, result.isValid());
		assertEquals(true, result.isEnabled());
		assertEquals(false, result.hasFocus());
		assertEquals(true, result.isVisible());
		assertEquals(null, result.getDropTarget());
		assertEquals(null, result.getFocusCycleRootAncestor());
		assertEquals(false, result.getFocusTraversalKeysEnabled());
		assertEquals(null, result.getGraphicsConfiguration());
		assertEquals(false, result.getIgnoreRepaint());
		assertEquals(null, result.getInputMethodRequests());
		assertEquals(null, result.getMousePosition());
		assertEquals(null, result.getPeer());
		assertEquals(true, result.isBackgroundSet());
		assertEquals(false, result.isCursorSet());
		assertEquals(false, result.isDisplayable());
		assertEquals(false, result.isFocusOwner());
		assertEquals(true, result.isFocusTraversable());
		assertEquals(true, result.isFocusable());
		assertEquals(true, result.isFontSet());
		assertEquals(true, result.isForegroundSet());
		assertEquals(false, result.isLightweight());
		assertEquals(false, result.isMaximumSizeSet());
		assertEquals(false, result.isMinimumSizeSet());
		assertEquals(false, result.isPreferredSizeSet());
		assertEquals(false, result.isShowing());
		assertEquals(null, result.getInputContext());
	}

	/**
	 * Run the JTabbedPane getTabs() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 27/10/14 9:06 AM
	 */
	@Test
	public void testGetTabs_1()
		throws Exception {
		LayoutManager fixture = new LayoutManager();
		fixture.fileLoad = new JMenuItem();

		JTabbedPane result = fixture.getTabs();

		// add additional test code here
		assertNotNull(result);
		assertEquals("TabbedPaneUI", result.getUIClassID());
		assertEquals(1, result.getTabCount());
		assertEquals(0, result.getTabLayoutPolicy());
		assertEquals(1, result.getTabPlacement());
		assertEquals(1, result.getTabRunCount());
		assertEquals(0, result.getSelectedIndex());
		assertEquals(false, result.isOpaque());
		assertEquals(null, result.getToolTipText());
		assertEquals(0, result.getWidth());
		assertEquals(0.5f, result.getAlignmentX(), 1.0f);
		assertEquals(0.5f, result.getAlignmentY(), 1.0f);
		assertEquals(false, result.isDoubleBuffered());
		assertEquals(false, result.isValidateRoot());
		assertEquals(0, result.getHeight());
		assertEquals(0, result.getX());
		assertEquals(0, result.getY());
		assertEquals(null, result.getBorder());
		assertEquals(null, result.getGraphics());
		assertEquals(false, result.requestFocusInWindow());
		assertEquals(false, result.getAutoscrolls());
		assertEquals(null, result.getComponentPopupMenu());
		assertEquals(0, result.getDebugGraphicsOptions());
		assertEquals(false, result.getInheritsPopupMenu());
		assertEquals(null, result.getInputVerifier());
		assertEquals(null, result.getNextFocusableComponent());
		assertEquals(null, result.getRootPane());
		assertEquals(null, result.getTopLevelAncestor());
		assertEquals(null, result.getTransferHandler());
		assertEquals(true, result.getVerifyInputWhenFocusTarget());
		assertEquals(false, result.isManagingFocus());
		assertEquals(true, result.isOptimizedDrawingEnabled());
		assertEquals(false, result.isPaintingForPrint());
		assertEquals(false, result.isPaintingTile());
		assertEquals(true, result.isRequestFocusEnabled());
		assertEquals(false, result.requestDefaultFocus());
		assertEquals(1, result.countComponents());
		assertEquals(1, result.getComponentCount());
		assertEquals(null, result.getFocusTraversalPolicy());
		assertEquals(false, result.isFocusCycleRoot());
		assertEquals(false, result.isFocusTraversalPolicyProvider());
		assertEquals(false, result.isFocusTraversalPolicySet());
		assertEquals("javax.swing.JTabbedPane[,0,0,0x0,invalid,layout=javax.swing.plaf.metal.MetalTabbedPaneUI$TabbedPaneLayout,alignmentX=0.0,alignmentY=0.0,border=,flags=352,maximumSize=,minimumSize=,preferredSize=,haveRegistered=false,tabPlacement=TOP]", result.toString());
		assertEquals(null, result.getName());
		assertEquals(null, result.getParent());
		assertEquals(false, result.isValid());
		assertEquals(true, result.isEnabled());
		assertEquals(false, result.hasFocus());
		assertEquals(true, result.isVisible());
		assertEquals(null, result.getDropTarget());
		assertEquals(null, result.getFocusCycleRootAncestor());
		assertEquals(true, result.getFocusTraversalKeysEnabled());
		assertEquals(null, result.getGraphicsConfiguration());
		assertEquals(false, result.getIgnoreRepaint());
		assertEquals(null, result.getInputMethodRequests());
		assertEquals(null, result.getMousePosition());
		assertEquals(null, result.getPeer());
		assertEquals(true, result.isBackgroundSet());
		assertEquals(false, result.isCursorSet());
		assertEquals(false, result.isDisplayable());
		assertEquals(false, result.isFocusOwner());
		assertEquals(true, result.isFocusTraversable());
		assertEquals(true, result.isFocusable());
		assertEquals(true, result.isFontSet());
		assertEquals(true, result.isForegroundSet());
		assertEquals(false, result.isLightweight());
		assertEquals(false, result.isMaximumSizeSet());
		assertEquals(false, result.isMinimumSizeSet());
		assertEquals(false, result.isPreferredSizeSet());
		assertEquals(false, result.isShowing());
		assertEquals(null, result.getInputContext());
	}

	/**
	 * Run the void populateFileHeader() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 27/10/14 9:06 AM
	 */
	@Test
	public void testPopulateFileHeader_1()
		throws Exception {
		LayoutManager fixture = new LayoutManager();
		fixture.fileLoad = new JMenuItem();

		fixture.populateFileHeader();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.IDG.controller.LayoutManager.populateFileHeader(LayoutManager.java:82)
	}

	/**
	 * Run the void populateFileHeader() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 27/10/14 9:06 AM
	 */
	@Test
	public void testPopulateFileHeader_2()
		throws Exception {
		LayoutManager fixture = new LayoutManager();
		fixture.fileLoad = new JMenuItem();

		fixture.populateFileHeader();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.IDG.controller.LayoutManager.populateFileHeader(LayoutManager.java:82)
	}

	/**
	 * Run the void populateFileHeader() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 27/10/14 9:06 AM
	 */
	@Test
	public void testPopulateFileHeader_3()
		throws Exception {
		LayoutManager fixture = new LayoutManager();
		fixture.fileLoad = new JMenuItem();

		fixture.populateFileHeader();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.IDG.controller.LayoutManager.populateFileHeader(LayoutManager.java:82)
	}

	/**
	 * Run the void populateFileHeader() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 27/10/14 9:06 AM
	 */
	@Test
	public void testPopulateFileHeader_4()
		throws Exception {
		LayoutManager fixture = new LayoutManager();
		fixture.fileLoad = new JMenuItem();

		fixture.populateFileHeader();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.IDG.controller.LayoutManager.populateFileHeader(LayoutManager.java:82)
	}

	/**
	 * Run the void populateFileHeader() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 27/10/14 9:06 AM
	 */
	@Test
	public void testPopulateFileHeader_5()
		throws Exception {
		LayoutManager fixture = new LayoutManager();
		fixture.fileLoad = new JMenuItem();

		fixture.populateFileHeader();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.IDG.controller.LayoutManager.populateFileHeader(LayoutManager.java:82)
	}

	/**
	 * Run the void populateFileHeader() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 27/10/14 9:06 AM
	 */
	@Test
	public void testPopulateFileHeader_6()
		throws Exception {
		LayoutManager fixture = new LayoutManager();
		fixture.fileLoad = new JMenuItem();

		fixture.populateFileHeader();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.IDG.controller.LayoutManager.populateFileHeader(LayoutManager.java:82)
	}

	/**
	 * Run the void populateFileHeader() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 27/10/14 9:06 AM
	 */
	@Test
	public void testPopulateFileHeader_7()
		throws Exception {
		LayoutManager fixture = new LayoutManager();
		fixture.fileLoad = new JMenuItem();

		fixture.populateFileHeader();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.IDG.controller.LayoutManager.populateFileHeader(LayoutManager.java:82)
	}

	/**
	 * Run the void populateFileHeader() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 27/10/14 9:06 AM
	 */
	@Test
	public void testPopulateFileHeader_8()
		throws Exception {
		LayoutManager fixture = new LayoutManager();
		fixture.fileLoad = new JMenuItem();

		fixture.populateFileHeader();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.IDG.controller.LayoutManager.populateFileHeader(LayoutManager.java:82)
	}

	/**
	 * Run the void populateFileHeader() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 27/10/14 9:06 AM
	 */
	@Test
	public void testPopulateFileHeader_9()
		throws Exception {
		LayoutManager fixture = new LayoutManager();
		fixture.fileLoad = new JMenuItem();

		fixture.populateFileHeader();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.IDG.controller.LayoutManager.populateFileHeader(LayoutManager.java:82)
	}

	/**
	 * Run the void populateFileHeader() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 27/10/14 9:06 AM
	 */
	@Test
	public void testPopulateFileHeader_10()
		throws Exception {
		LayoutManager fixture = new LayoutManager();
		fixture.fileLoad = new JMenuItem();

		fixture.populateFileHeader();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.IDG.controller.LayoutManager.populateFileHeader(LayoutManager.java:82)
	}

	/**
	 * Run the void populateFileHeader() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 27/10/14 9:06 AM
	 */
	@Test
	public void testPopulateFileHeader_11()
		throws Exception {
		LayoutManager fixture = new LayoutManager();
		fixture.fileLoad = new JMenuItem();

		fixture.populateFileHeader();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.IDG.controller.LayoutManager.populateFileHeader(LayoutManager.java:82)
	}

	/**
	 * Run the void populateFileHeader() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 27/10/14 9:06 AM
	 */
	@Test
	public void testPopulateFileHeader_12()
		throws Exception {
		LayoutManager fixture = new LayoutManager();
		fixture.fileLoad = new JMenuItem();

		fixture.populateFileHeader();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.IDG.controller.LayoutManager.populateFileHeader(LayoutManager.java:82)
	}

	/**
	 * Run the void populateFileHeader() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 27/10/14 9:06 AM
	 */
	@Test
	public void testPopulateFileHeader_13()
		throws Exception {
		LayoutManager fixture = new LayoutManager();
		fixture.fileLoad = new JMenuItem();

		fixture.populateFileHeader();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.IDG.controller.LayoutManager.populateFileHeader(LayoutManager.java:82)
	}

	/**
	 * Run the void populateFileHeader() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 27/10/14 9:06 AM
	 */
	@Test
	public void testPopulateFileHeader_14()
		throws Exception {
		LayoutManager fixture = new LayoutManager();
		fixture.fileLoad = new JMenuItem();

		fixture.populateFileHeader();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.IDG.controller.LayoutManager.populateFileHeader(LayoutManager.java:82)
	}

	/**
	 * Run the void populateFileHeader() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 27/10/14 9:06 AM
	 */
	@Test
	public void testPopulateFileHeader_15()
		throws Exception {
		LayoutManager fixture = new LayoutManager();
		fixture.fileLoad = new JMenuItem();

		fixture.populateFileHeader();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.IDG.controller.LayoutManager.populateFileHeader(LayoutManager.java:82)
	}

	/**
	 * Run the void populateFileHeader() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 27/10/14 9:06 AM
	 */
	@Test
	public void testPopulateFileHeader_16()
		throws Exception {
		LayoutManager fixture = new LayoutManager();
		fixture.fileLoad = new JMenuItem();

		fixture.populateFileHeader();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.IDG.controller.LayoutManager.populateFileHeader(LayoutManager.java:82)
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 27/10/14 9:06 AM
	 */
	@Before
	public void setUp()
		throws Exception {
		// add additional set up code here
	}

	/**
	 * Perform post-test clean-up.
	 *
	 * @throws Exception
	 *         if the clean-up fails for some reason
	 *
	 * @generatedBy CodePro at 27/10/14 9:06 AM
	 */
	@After
	public void tearDown()
		throws Exception {
		// Add additional tear down code here
	}

	/**
	 * Launch the test.
	 *
	 * @param args the command line arguments
	 *
	 * @generatedBy CodePro at 27/10/14 9:06 AM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(LayoutManagerTest.class);
	}
}