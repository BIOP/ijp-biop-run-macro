package ch.epfl.biop.macrorunner;

import java.io.File;
import java.io.FileNotFoundException;

import javax.script.ScriptException;

import org.scijava.command.Command;
import org.scijava.log.LogService;
import org.scijava.plugin.Parameter;
import org.scijava.plugin.Plugin;
import org.scijava.script.ScriptService;

@Plugin(type= Command.class, menuPath="Plugins>BIOP>Macro>BIOP Run Macro...")
public class B_Run_Macro implements Command {
	
	@Parameter
	private File macro_file;
	
	@Parameter
	private LogService logService;
	
	@Parameter
	private ScriptService scriptService;
	
	@Override
	public void run() {
		try {
			scriptService.run(macro_file, true);
		} catch (FileNotFoundException | ScriptException e) {
			// TODO Auto-generated catch block
			logService.error(e.toString());
		}
	}
	
}
