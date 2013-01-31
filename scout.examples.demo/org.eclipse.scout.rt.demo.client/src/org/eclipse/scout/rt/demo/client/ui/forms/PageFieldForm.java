package org.eclipse.scout.rt.demo.client.ui.forms;

import org.eclipse.scout.commons.annotations.Order;
import org.eclipse.scout.commons.exception.ProcessingException;
import org.eclipse.scout.rt.client.ui.desktop.outline.pages.IPage;
import org.eclipse.scout.rt.client.ui.form.AbstractForm;
import org.eclipse.scout.rt.client.ui.form.AbstractFormHandler;
import org.eclipse.scout.rt.client.ui.form.fields.button.AbstractCloseButton;
import org.eclipse.scout.rt.client.ui.form.fields.groupbox.AbstractGroupBox;
import org.eclipse.scout.rt.client.ui.form.fields.pagefield.AbstractPageField;
import org.eclipse.scout.rt.demo.client.ui.desktop.outlines.pages.PageWithADetailformTablePage;
import org.eclipse.scout.rt.demo.client.ui.forms.PageFieldForm.MainBox.CloseButton;
import org.eclipse.scout.rt.demo.client.ui.forms.PageFieldForm.MainBox.PageBox;
import org.eclipse.scout.rt.shared.TEXTS;

public class PageFieldForm extends AbstractForm implements IPageForm {

  public PageFieldForm() throws ProcessingException {
    super();
  }

  @Override
  protected String getConfiguredTitle() {
    return TEXTS.get("PageField");
  }

  @Override
  public void startPageForm() throws ProcessingException {
    startInternal(new PageFormHandler());
  }

  public CloseButton getCloseButton() {
    return getFieldByClass(CloseButton.class);
  }

  public MainBox getMainBox() {
    return getFieldByClass(MainBox.class);
  }

  public PageBox getPageBox() {
    return getFieldByClass(PageBox.class);
  }

  @Order(10.0)
  public class MainBox extends AbstractGroupBox {

    @Order(10.0)
    public class PageBox extends AbstractPageField<IPage> {

      @Override
      protected boolean getConfiguredLabelVisible() {
        return false;
      }

      @Override
      protected void execInitField() throws ProcessingException {
        setPage(new PageWithADetailformTablePage());
      }
    }

    @Order(20.0)
    public class CloseButton extends AbstractCloseButton {
    }
  }

  public class PageFormHandler extends AbstractFormHandler {
  }
}