import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Component;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class ListenToLoad extends Component implements ActionListener  {

	public void actionPerformed(ActionEvent evt) {
		JFileChooser choice = new JFileChooser();
        int option = choice.showOpenDialog(this);
        File mapFile=null;
        if (option == JFileChooser.APPROVE_OPTION) {
            try{
            	mapFile=choice.getSelectedFile();
            }catch(Exception e){
            }
            }
        List<String> lines=new ArrayList();
        Scanner sc=null;
		try {
			sc = new Scanner(mapFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(sc.hasNextLine()) {
			lines.add(sc.nextLine());
		}

		// to array
		int rows = lines.size();              // number of rows
		int cols = 0;                         // number of columns
		for(String line : lines) {
			cols = Math.max(cols, line.length());
		}
		int i = 0,j=0;

		wall buttons[][]=new wall[rows][cols];
		for(String line : lines) {            // for each line, add the 1s
			char[] chars = line.toCharArray();
			for(j = 0 ; j < chars.length ; ++j) {
				wall wl=new wall();
				buttons[i][j]=wl;
				wl.setDirection(chars[j]);
				switch(chars[j]) {
				case 'B':
					wl.setIcon(null);
					wl.setPath(false);
					break;
				case 'U':
					wl.setIcon(wl.getUpDirectionImg());
					wl.setPath(true);
					wl.setDirection('U');
					break;
				case 'R':
					wl.setIcon(wl.getRightDirectionImg());
					wl.setPath(true);
					wl.setDirection('R');
					break;
				case 'D':
					wl.setIcon(wl.getDownDirectionImg());
					wl.setPath(true);
					wl.setDirection('D');
					break;
				case 'L':
					wl.setIcon(wl.getLeftDirectionImg());
					wl.setPath(true);
					wl.setDirection('L');
					break;
					

				}
			}
			i++;
		}
		
		
	}

}
