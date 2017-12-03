package jamesbaker.adventofcode;

import java.util.StringJoiner;

public class Day3 extends AbstractDay {

	public static void main(String[] args) {
		new Day3().run("day3.txt");
	}
	
	@Override
	public Object calculatePart1(String input) {
		int target = Integer.valueOf(input);
		LOGGER.debug("Target: "+target);
		
		//Calculate the layer
		int size;
		for(size = 1; size*size < target; size += 2);
		LOGGER.debug("Layer size: "+size);
		int sizeIncrement = size - 1;
		
		int layerStart = ((size-2)*(size-2)+1);
		LOGGER.debug("Layer start: "+layerStart);
		
		//Calculate the side
		if(layerStart - 1 + 1*sizeIncrement == target || layerStart - 1 + 2*sizeIncrement == target || layerStart - 1 + 3*sizeIncrement == target || layerStart - 1 + 4*sizeIncrement == target)
			//Target is in a corner
			return sizeIncrement;
		
		int offset = 0;
		if(layerStart - 1 + 1*sizeIncrement > target) {
			//Target is on right
			offset = calculateOffset(layerStart - 1, target, size);
		} else if(layerStart - 1 + 2*sizeIncrement > target) {
			//Target is on top
			offset = calculateOffset(layerStart - 1 + 1*sizeIncrement, target, size);
		} else if(layerStart - 1 + 3*sizeIncrement > target) {
			//Target is on left
			offset = calculateOffset(layerStart - 1 + 2*sizeIncrement, target, size);
		} else if(layerStart - 1 + 4*sizeIncrement > target) {
			//Target is on bottom
			offset = calculateOffset(layerStart - 1 + 3*sizeIncrement, target, size);
		}
		
		return sizeIncrement/2 + offset;
	}
	
	private int calculateOffset(int start, int target, int size) {
		int steps = 0;
		for(steps = 0; start + steps < target; steps++);
		
		return Math.abs(-(size - 1)/2 + steps);
	}

	@Override
	public Object calculatePart2(String input) {
		int target = Integer.valueOf(input);
		LOGGER.debug("Target: "+target);
		
		//Calculate the maximum layer size
		int size;
		for(size = 1; size*size < target; size += 2);
		
		int[][] grid = new int[size][size];
		int x = (size - 1) / 2;
		int y = (size - 1) / 2;
		grid[x][y] = 1;
		
		int xDir = 1;
		int yDir = 0;
		int layerSize = 1;
		int steps = 1;
		
		while(true) {
			x += xDir;
			y += yDir;
			
			grid[x][y] = sumAdjacent(grid, x, y);
			if(LOGGER.isDebugEnabled())
				printGrid(grid, size);
			if(grid[x][y] > target)
				return grid[x][y];

			steps++;
			
			if((xDir == 1 && steps >= layerSize) || (xDir != 1 && steps >= layerSize - 1)) {
				//Change direction
				steps = 0;
				
				if(xDir == 1 && yDir == 0) {
					xDir = 0;
					yDir = -1;
					layerSize += 2;
					steps = 1;	//We start not in the bottom corner for this direction
				}else if(xDir == 0 && yDir == -1) {
					xDir = -1;
					yDir = 0;
				}else if(xDir == -1 && yDir == 0) {
					xDir = 0;
					yDir = 1;
				}else {
					xDir = 1;
					yDir = 0;
				}
			}
		}
	}
	
	private int sumAdjacent(int[][] grid, int x, int y) {
		int sum = 0;
		sum += getInt(grid, x - 1, y - 1);
		sum += getInt(grid, x - 1, y);
		sum += getInt(grid, x - 1, y + 1);
		sum += getInt(grid, x + 1, y - 1);
		sum += getInt(grid, x + 1, y);
		sum += getInt(grid, x + 1, y + 1);
		sum += getInt(grid, x, y - 1);
		sum += getInt(grid, x, y + 1);
		
		return sum;
	}
	
	private int getInt(int[][] grid, int x, int y) {
		if(x >= grid.length || x < 0)
			return 0;
		
		if(y >= grid[x].length || y < 0)
			return 0;
		
		return grid[x][y];
	}
	
	private void printGrid(int[][] grid, int size) {
		StringJoiner sjGrid = new StringJoiner("\n");
		for(int y = 0; y < size; y++) {
			StringJoiner sjLine = new StringJoiner(" ");
			for(int x = 0; x < size; x++) {
				sjLine.add(Integer.toString(grid[x][y]));
			}
			
			sjGrid.add(sjLine.toString());
		}
		LOGGER.debug(sjGrid.toString());
	}

}
