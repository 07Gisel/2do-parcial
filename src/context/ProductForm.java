package context;

import java.awt.Dimension;
import java.awt.Button;
import java.awt.TextField;

import data.models.CreateProduct;
import i18n.TextCodes;
import i18n.Translations;
import ui.custom.BaseWindow;
import ui.custom.ButtonComponent;
import ui.custom.PanelBox;
import ui.custom.TextFieldComponent;

public class ProductForm extends BaseWindow {
    private TextFieldComponent nameField;
    private TextFieldComponent descripcionField;
    private TextFieldComponent tipoField;
    private TextFieldComponent precioField;
    private ButtonComponent productButton;
    private Translations lang;
    private PanelBox panel;
    public ProductForm(Translations lang, String title) {
        super(title);
        this.lang = lang;
        this.setSize(new Dimension(350, 400));
        
        createForm();
    }
    public void createForm() {
        panel = new PanelBox();
        panel.setSize(new Dimension(350, 400));
        panel.roundedBorder(20);
        panel.setLayout(null);
        
        nameField = new TextFieldComponent(lang.getI18nText(TextCodes.nameTextField), this.panel);
        nameField.setPosition(40);
        nameField.setSize(new Dimension(260, 40));
        nameField.setPlaceHolder(lang.getI18nText(TextCodes.userNameTextField));
        this.panel.add(nameField);
        descripcionField = new TextFieldComponent(lang.getI18nText(TextCodes.descripcionTextField), this.panel);
        descripcionField.setPosition(80);
        descripcionField.setSize(new Dimension(260, 40));
        descripcionField.setPlaceHolder(lang.getI18nText(TextCodes.descripcionTextField));
        this.panel.add(descripcionField);
        tipoField = new TextFieldComponent(title, this.panel);
        tipoField.setPosition(120);
        tipoField.setSize(new Dimension(260, 40));
        this.panel.add(tipoField);
        precioField = new TextFieldComponent(lang.getI18nText(TextCodes.precio), this.panel);
        precioField.setPosition(160);
        precioField.setSize(new Dimension(260, 40));
        precioField.setPlaceHolder(lang.getI18nText(TextCodes.precio));
        this.panel.add(precioField);
        productButton = new ButtonComponent(lang.getI18nText(TextCodes.productText), this.panel);
        productButton.setPosition(200);
        productButton.setSize(new Dimension(260, 40));
        productButton.addActionListener((event) -> {
            CreateProduct createProduct = new CreateProduct(this.nameField.getText(), this.descripcionField.getText(), this.tipoField.getText(), this.precioField.getText());
           this.getListener().onEvent("click", createProduct); 
        });
        this.panel.add(productButton);
        this.add(this.panel);
    }
}
