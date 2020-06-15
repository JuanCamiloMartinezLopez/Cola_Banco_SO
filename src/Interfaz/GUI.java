package Interfaz;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import Logica.Cola;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Slider;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Table;

public class GUI {
	protected Cola cola;
	protected Shell shell;
	private Text clientes;
	Button btnAtender;
	Label lblColaVacia;
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			GUI window = new GUI();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		cola=new Cola();
		shell = new Shell();
		shell.setSize(474, 323);
		shell.setText("Cola de Banco");
		
		clientes = new Text(shell, SWT.BORDER);
		clientes.setBounds(93, 104, 337, 21);
		clientes.setEditable(false);
		clientes.setEnabled(false);
		
		lblColaVacia = new Label(shell, SWT.NONE);
		lblColaVacia.setBounds(221, 131, 55, 15);
		lblColaVacia.setText("Cola Vacia");
		lblColaVacia.setVisible(false);
		
		
		btnAtender = new Button(shell, SWT.NONE);
		btnAtender.setEnabled(false);
		btnAtender.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				cola.atender();
				clientes.setText(cola.dibujar());
				if(cola.isEmpty()) {
					btnAtender.setEnabled(false);
					lblColaVacia.setVisible(true);
				}
			}
		});
		btnAtender.setBounds(94, 225, 75, 25);
		btnAtender.setText("Atender");
		
		Label lblNumeroDeRecibos = new Label(shell, SWT.NONE);
		lblNumeroDeRecibos.setBounds(239, 206, 108, 15);
		lblNumeroDeRecibos.setText("Numero de recibos");
		
		Button btnAgregar = new Button(shell, SWT.NONE);
		
		btnAgregar.setBounds(355, 225, 75, 25);
		btnAgregar.setText("Agregar");
		
		Spinner nRecibos = new Spinner(shell, SWT.BORDER);
		nRecibos.setMinimum(1);
		nRecibos.setSelection(1);
		nRecibos.setBounds(274, 227, 47, 22);
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setTextDirection(3355);
		lblNewLabel.setAlignment(SWT.CENTER);
		lblNewLabel.setBounds(10, 110, 55, 15);
		lblNewLabel.setText("Cajero");
		
		btnAgregar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int num= nRecibos.getSelection();
				//System.out.println(num);
				cola.insertar(num);
				clientes.setText(cola.dibujar());
				lblColaVacia.setVisible(false);
				btnAtender.setEnabled(true);
				cola.mostrar();
			}
		});
		
		
	}
}
