package com.IDG.playGame;

import java.awt.Point;
import java.util.LinkedList;

import com.IDG.mapSimulator.Block;
import com.IDG.mapSimulator.MapSimulatorView;
/**
 * This class is used to map the path followed by enemy
 * @author Arjun
 *
 */
public class EnemyPath {
	/**
	 * Entery and exit coordinates of enemy
	 */
	public static int entryX, entryY, exitX, exitY;
	/**
	 * Width and height of enemy
	 */
	private static int width, height;
	/**
	 * this will check if enemy has already followed this path
	 */
	private static boolean wasHere[][];
	/**
	 * Contain the copy of path
	 */
	private static LinkedList<Point> copiedPath = new LinkedList<Point>();
	/**
	 * Contain the map
	 */
	private static Block[][] map;
	
	/**
	 * This method copy the enemy path
	 * @return return the copied enemy path
	 */
	public static LinkedList<Point> copyPath() {
		width = MapSimulatorView.gridRow;
		height = MapSimulatorView.gridColumn;
		wasHere = new boolean[width][height];
		map = new Block[width][height];

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				map[i][j] = MapSimulatorView.room.block[i][j];
			}
		}

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++)
				if (MapSimulatorView.gameValue[i][j] == 'S') {
					entryX = i;
					entryY = j;
				} else if (MapSimulatorView.gameValue[i][j] == 'E') {
					exitX = i;
					exitY = j;
				}
		}

		if (!(copiedPath.isEmpty()))
			copiedPath.clear();

		boolean pathCopied = false;
		pathCopied = copyPathPoints(entryX, entryY);
		if (pathCopied)
			copiedPath.addLast(addPoint(exitX, exitY));
		return copiedPath;
	}
	/**
	 * This method copy the Path points
	 * @param entryX2 X coordinate of path
	 * @param entryY2 Y coordinate of path
	 * @return return the boolean if the path has been traveresed or not
	 */
	private static boolean copyPathPoints(int entryX2, int entryY2) {

		if (entryX2 == exitX && entryY2 == exitY)
			return true;

		char createId = MapSimulatorView.gameValue[entryX2][entryY2];
		if (createId == '*' || createId == 'R' || createId == 'B'
				|| createId == 'G' || wasHere[entryX2][entryY2])
			return false;

		wasHere[entryX2][entryY2] = true;

		if (entryX2 != 0)
			if (copyPathPoints(entryX2 - 1, entryY2)) {
				copiedPath.addFirst(addPoint(entryX2, entryY2));
				return true;
			}

		if (entryX2 != width - 1)
			if (copyPathPoints(entryX2 + 1, entryY2)) {
				copiedPath.addFirst(addPoint(entryX2, entryY2));
				return true;
			}

		if (entryY2 != 0)
			if (copyPathPoints(entryX2, entryY2 - 1)) {
				copiedPath.addFirst(addPoint(entryX2, entryY2));
				return true;
			}

		if (entryY2 != height - 1)
			if (copyPathPoints(entryX2, entryY2 + 1)) {
				copiedPath.addFirst(addPoint(entryX2, entryY2));
				return true;
			}

		return false;
	}
	/**
	 * Add new point
	 * @param x X coordinate of path
	 * @param y Y coordinate of path
	 * @return return the newly added path
	 */
	private static Point addPoint(int x, int y) {
		Point point;
		point = new Point(map[x][y].x, map[x][y].y);
		return point;
	}

}
