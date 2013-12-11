package org.multibit.hd.ui.views.wizards.send_bitcoin;

import net.miginfocom.swing.MigLayout;
import org.multibit.hd.ui.views.components.Buttons;
import org.multibit.hd.ui.views.components.Labels;
import org.multibit.hd.ui.views.components.Panels;
import org.multibit.hd.ui.views.wizards.AbstractWizard;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * <p>Wizard to provide the following to UI:</p>
 * <ul>
 * <li>Send bitcoin: Confirm send</li>
 * </ul>
 *
 * @since 0.0.1
 *         
 */

public class SendBitcoinProgressPanel extends JPanel {

  private final AbstractWizard wizard;

  /**
   * The "finish" action
   */
  private Action finishAction = new AbstractAction() {
    @Override
    public void actionPerformed(ActionEvent e) {
      wizard.close();
    }
  };

  /**
   * @param wizard The wizard managing the states
   */
  public SendBitcoinProgressPanel(AbstractWizard wizard) {

    this.wizard = wizard;

    MigLayout layout = new MigLayout(
      "fill", // Layout constrains
      "[]", // Column constraints
      "[grow]" // Row constraints
    );
    setLayout(layout);

    add(addWizardComponents(), "grow,wrap");

    add(Buttons.newFinishButton(finishAction), "right");

  }


  private JPanel addWizardComponents() {

    JPanel panel = new JPanel(new MigLayout(
      "fill", // Layout constrains
      "[][][]", // Column constraints
      "[]10[]10[]10[]" // Row constraints
    ));
    panel.add(Labels.newSendProgressTitle(),"wrap");
    panel.add(Panels.newBroadcastStatus(),"wrap");
    panel.add(Panels.newRelayStatus(),"wrap");
    panel.add(Panels.newConfirmationCount(),"wrap");

    return panel;
  }

}
