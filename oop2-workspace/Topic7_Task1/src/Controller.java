
import java.io.IOException;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;

public class Controller {

	private DateTimeFormatter formatter;
	private NumberFormat numberFormat;
	private NumberFormat preNumberFormat;

	@FXML
	private ResourceBundle resources;
	@FXML
	private Label label;
	@FXML
	private Label label2;
	@FXML
	private Label label3;

	@FXML
	public void initialize() {
		createFormatters();
		setLabels();
	}

	@FXML
	protected void clickMe(ActionEvent event) {
		setLabels();
	}

	@FXML
	protected void changeLanguageEn(ActionEvent event) throws IOException {
		setLanguages(Locale.UK);
	}

	@FXML
	protected void changeLanguageDe(ActionEvent event) throws IOException {
		setLanguages(Locale.GERMANY);
	}

	private void createFormatters() {
		Locale locale = resources.getLocale();
		formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(locale);
		numberFormat = NumberFormat.getCurrencyInstance(locale);
		preNumberFormat = NumberFormat.getPercentInstance(locale);
	}

	private void setLabels() {
		Object[] labelArgs = { formatter.format(LocalDate.now()) };
		label.setText(MessageFormat.format(getI18nString("label.text"), labelArgs));

		LocalTime now = LocalTime.now();
		Object[] label1Args = { now.getHour(), now.getMinute(), now.getSecond() };
		label2.setText(MessageFormat.format(getI18nString("label2.text"), label1Args));

		Object[] label2Args = { numberFormat.format(Math.random() * 100), preNumberFormat.format(Math.random()) };
		label2.setText(MessageFormat.format(getI18nString("label3.text"), label2Args));

	}

	private String getI18nString(String key) {
		try {
			return resources.getString(key);
		} catch (MissingResourceException e) {
			// TODO: handle exception
			System.err.println("Missing key " + key + " in " + resources.getBaseBundleName());
			return "! " + key + " !";
		}
	}

	private void setLanguages(Locale locale) throws IOException {
		if (!locale.equals(resources.getLocale())) {
			resources = ResourceBundle.getBundle("example", locale);
		}
		FXMLLoader loader = new FXMLLoader(getClass().getResource("View.fxml"), resources);
		Parent root = loader.load();
		Scene scene = this.label.getScene();
		scene.setRoot(root);

	}
}
