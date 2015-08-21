package consoledisplaytrace.handlers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;


/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class SampleHandler extends AbstractHandler {
	/**
	 * The constructor.
	 */
	public SampleHandler() {
	}

	/**
	 * the command has been executed, so extract extract the needed information
	 * from the application context.
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		MessageDialog.openInformation(
				window.getShell(),
				"ConsoleDisplayTrace",
				"Display Trace on the Output");
		InputStream is;
		try{
			File f = new File("/home/suchita/Desktop/sample2.csv");
			is = new FileInputStream(f);
			insertData(is);
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return null;
	}

	private void insertData(InputStream is) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(is);
		while (scan.hasNextLine()){
			String line = scan.nextLine();
			System.out.println(line);
	}
		scan.close();
	}
}
