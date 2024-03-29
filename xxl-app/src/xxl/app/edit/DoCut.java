package xxl.app.edit;

import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
import xxl.Spreadsheet;

import xxl.exceptions.InvalidCellRangeCoreException;

/**
 * Cut command.
 */
class DoCut extends Command<Spreadsheet> {

    DoCut(Spreadsheet receiver) {
        super(Label.CUT, receiver);
        addStringField("gama",Prompt.address());
    }

    @Override
    protected final void execute() throws CommandException {
        String gama = stringField("gama");
        try{
            _receiver.cut(gama);
        }
        catch(InvalidCellRangeCoreException e){
            throw new InvalidCellRangeException(gama);
        }
    }

}
