package proyectomundial;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class GUIManual extends JFrame {

    public String[][] tabla_contador = new String[5][2];
    public int c_home = 0;
    public int c_selecciones = 0;
    public int c_resultados = 0;
    public int c_dseleciones = 0;
    public int c_dresultados = 0;

    public String[][] menualeatorio = null;
    // Matrix que permite almancenar la información de las selecciones futbol cargadas
    public String[][] selecciones = null;
    public String[][] selecciones_clasificacion = null;
    public String[][] filtro = null;
    // Matriz que permite almacenar los resultados de los partidos cargardos
    public String[][] resultados = null;
    public String[][] resultados_clasificacion = null;
    public String[][] selecionesxgoles = null;
    public String[][] clasificacion_grupos = null;
    public String[][] pm_golesxpartido = null;

    public int contador = 0;
    // Elementos de bara Lateral
    private JPanel jPanelLeft;

    private JPanel jPanelIconFIFA;
    private JLabel iconFIFA;

    // Elementos de opciones de Menú
    private JPanel jPanelMenu;

    private JPanel jPanelMenuHome;
    private JLabel btnHome;

    private JPanel jPanelpika;
    private JLabel btnpika;
    private JPanel jPanelcontador;
    private JLabel btncontador;

    private JPanel jPanelMenuSelecciones;
    private JLabel btnSelecciones;

    private JPanel jPanelMenuResultados;
    private JLabel btnResultados;

    private JPanel jPanelMenuDashboardSel;
    private JLabel btnDashboardSel;

    private JPanel jPanelMenuDashboardRes;
    private JLabel btnDashboardRes;

    // Elementos de panel de contenido
    private JPanel jPanelRight;
    private JPanel jPanelLabelTop;
    private JLabel jLabelTop;

    private JPanel jPanelMain;

    public GUIManual() {

        // Se inician los componentes gráficos
        initComponents();

        // Se configuran propiedades de nuestra Ventana
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        // Se llama la función home para que al momento de iniciar la aplicacoón, por defecto se muestre el home
        accionHome();

    }

    private void initComponents() {

        // Inicializamos componentes del Menu Lateral
        jPanelLeft = new JPanel();

        jPanelIconFIFA = new JPanel();
        iconFIFA = new JLabel();
        jPanelMenu = new JPanel();

        jPanelMenuHome = new JPanel();
        btnHome = new JLabel();

        jPanelcontador = new JPanel();
        btncontador = new JLabel();

        jPanelpika = new JPanel();
        btnpika = new JLabel();

        jPanelMenuSelecciones = new JPanel();
        btnSelecciones = new JLabel();

        jPanelMenuResultados = new JPanel();
        btnResultados = new JLabel();

        jPanelMenuDashboardSel = new JPanel();
        btnDashboardSel = new JLabel();

        jPanelMenuDashboardRes = new JPanel();
        btnDashboardRes = new JLabel();

        // Pinta el logo de la aplicación
        pintarLogo();

        // Pinta la opción de menú del Home
        pintarMenuHome();

        // Pinta la opción de Menú de las Selecciones
        pintarMenuSelecciones();

        // Pinta la opción de Menú de los resultados
        pintarMenuResultados();

        // Pinta la opción de Menú del dashboard de equipo
        pintarMenuDashboardSel();

        // Pinta la opción de Menú del dahboard de resultados
        pintarMenuDashboardRes();

        // Pinta y ajuste diseño del contenedor del panel izquierdo
        pintarPanelIzquierdo();
        tabla_contadores();

        menualeatorio();

        // Inicializa los componentes del panel derecho de los contenidos
        jPanelRight = new JPanel();
        jPanelLabelTop = new JPanel();
        jPanelMain = new JPanel();

        // Pinta la barra superrior de color azul claro, del panel de contenido
        pintarLabelTop();

        // Pinta y ajusta diseño del contenedor de contenidos
        pintarPanelDerecho();
        setTitle("Mundial");
        pack();
        setVisible(true);
    }

    private void pintarLogo() {
        jPanelIconFIFA.add(iconFIFA);
        jPanelIconFIFA.setOpaque(false);
        jPanelIconFIFA.setPreferredSize((new java.awt.Dimension(220, 80)));
        jPanelIconFIFA.setMaximumSize(jPanelIconFIFA.getPreferredSize());
        iconFIFA.setIcon(new ImageIcon(getClass().getResource("/resources/Easports_fifa_logo.svg.png")));
        jPanelLeft.add(jPanelIconFIFA, BorderLayout.LINE_START);

    }

    private void pintarMenuHome() {
        /**
         * Función que se encarga de ajustar los elementos gráficos que
         * componente la opción de navegación del HOME Define estilos,
         * etiquetas, iconos que decoran la opción del Menú. Esta opción de Menu
         * permite mostrar la página de bienvenida de la aplicación
         */
        btnHome.setIcon(new ImageIcon(getClass().getResource("/resources/icons/home.png"))); // NOI18N
        btnHome.setText("Incio");
        btnHome.setForeground(new java.awt.Color(255, 255, 255));
        btnHome.setFont(new Font("Courier New", Font.BOLD, 17));

        JLabel vacioHome = new JLabel();
        jPanelMenuHome.setBackground(new java.awt.Color(9, 128, 82));
        jPanelMenuHome.setPreferredSize((new java.awt.Dimension(220, 35)));
        jPanelMenuHome.setLayout(new BorderLayout(15, 0));
        jPanelMenuHome.add(vacioHome, BorderLayout.WEST);
        jPanelMenuHome.add(btnHome, BorderLayout.CENTER);
        jPanelMenu.add(jPanelMenuHome);

        btnHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                System.out.println("Incio");
                accionHome();
                int recurso = 1;
                excuttabla_contadores(recurso);
            }
        });

    }

    private void accionHome() {
        /**
         * Función que se ejecuta cuando el usuario hacer click sobre la opción
         * de navegación Home Permite modificar la etiqueta de Navegación en
         * Home, remover los elementos que hay en el panel de contenidos y
         * agregar la imagen de inicio de la aplicación
         */
        jLabelTop.setText("Inicio");
        //jLabelTopDescription.setText("Bienvenido al sistema de gestión de mundiales de fútbol");

        jPanelMain.removeAll();
        JPanel homePanel = new JPanel();
        JLabel imageHome = new JLabel();

        ImageIcon icon = new ImageIcon(getClass().getResource("/resources/home.jpg"));
        Image img = icon.getImage().getScaledInstance(jPanelMain.getWidth(), jPanelMain.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(img);
        imageHome.setIcon(scaledIcon);

        homePanel.add(imageHome);

        jPanelMain.add(homePanel, BorderLayout.CENTER);
        jPanelMain.repaint();
        jPanelMain.revalidate();
    }

    private void pintarMenuSelecciones() {
        /**
         * Función que se encarga de ajustar los elementos gráficos que
         * componente la opción de navegación de SELECCIONES Define estilos,
         * etiquetas, iconos que decoran la opción del Menú. Esta opción de Menu
         * permite mostrar las selecciones de futbol cargadas en la aplicación
         */
        btnSelecciones.setIcon(new ImageIcon(getClass().getResource("/resources/icons/selecciones.png"))); // NOI18N
        btnSelecciones.setText("Selecciones");
        btnSelecciones.setForeground(new java.awt.Color(255, 255, 255));
        btnSelecciones.setFont(new Font("Courier New", Font.BOLD, 17));

        JLabel vacioSelecciones = new JLabel();
        jPanelMenuSelecciones.setBackground(new java.awt.Color(9, 128, 82));
        jPanelMenuSelecciones.setPreferredSize((new java.awt.Dimension(220, 35)));
        jPanelMenuSelecciones.setLayout(new BorderLayout(15, 0));
        jPanelMenuSelecciones.add(vacioSelecciones, BorderLayout.WEST);
        jPanelMenuSelecciones.add(btnSelecciones, BorderLayout.CENTER);
        jPanelMenu.add(jPanelMenuSelecciones);

        btnSelecciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                System.out.println("Selecciones");
                accionSelecciones();
                int recurso = 2;
                excuttabla_contadores(recurso);
            }
        });
    }

    private void accionSelecciones() {
        /**
         * Función que se ejecuta cuando el usuario hace click sobre la opción
         * de navegación Selecciones Permite ver la lista de selecciones que se
         * encuentran cargadas en la aplicación. Si la lista de selecciones en
         * vacía, muestra un botón que permite cargar un archivo CSV con la
         * información de las selelecciones
         */
        jLabelTop.setText("Selecciones");

        // Si no hay selecciones cargadas, muestra el botón de carga de selecciones
        if (selecciones == null) {
            jPanelMain.removeAll();
            JPanel seleccionesPanel = new JPanel();

            if (selecciones == null) {

                JLabel notSelecciones = new JLabel();
                notSelecciones.setText("No hay selecciones cargadas, por favor cargue selecciones \n\n");
                seleccionesPanel.add(notSelecciones);

                JButton cargarFile = new JButton();
                cargarFile.setText("Seleccione el archivo");
                seleccionesPanel.add(cargarFile);
                cargarFile.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        cargarFileSelecciones();
                    }
                });
            }

            jPanelMain.add(seleccionesPanel);
            jPanelMain.repaint();
            jPanelMain.revalidate();
        } // Si hay selecciones cargadas, llama el método que permite pintar la tabla de selecciones
        else {
            int imprimirtablafiltro = 2;
            pintarTablaSelecciones(imprimirtablafiltro);
        }
    }

    private void pintarMenuResultados() {
        /**
         * Función que se encarga de ajustar los elementos gráficos que
         * componente la opción de navegación de RESULTADOS Define estilos,
         * etiquetas, iconos que decoran la opción del Menú. Esta opción de Menu
         * permite mostrar los diferentes resultados de los partidos de la fase
         * de grupos de un mundial
         */
        btnResultados.setIcon(new ImageIcon(getClass().getResource("/resources/icons/resultados.png"))); // NOI18N
        btnResultados.setText("Resultados");
        btnResultados.setForeground(new java.awt.Color(255, 255, 255));
        btnResultados.setFont(new Font("Courier New", Font.BOLD, 17));

        JLabel vacioResultados = new JLabel();
        jPanelMenuResultados.setBackground(new java.awt.Color(9, 128, 82));
        jPanelMenuResultados.setPreferredSize((new java.awt.Dimension(220, 35)));
        jPanelMenuResultados.setLayout(new BorderLayout(15, 0));
        jPanelMenuResultados.add(vacioResultados, BorderLayout.WEST);
        jPanelMenuResultados.add(btnResultados, BorderLayout.CENTER);
        jPanelMenu.add(jPanelMenuResultados);

        btnResultados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                System.out.println("Resultados");
                accionResultados();
                int recurso = 3;
                excuttabla_contadores(recurso);
            }
        });
    }

    private void accionResultados() {
        /**
         * Función que se ejecuta cuando el usuario hace click sobre la opción
         * de navegación Resultados Permite ver la lista de resultados que se
         * encuentran cargadas en la aplicación. Si la lista de resultados en
         * vacía, muestra un botón que permite cargar un archivo CSV con la
         * información de los resultados
         */
        jLabelTop.setText("Resultados");

        // Si no hay resultados cargados, muestra el botón de carga de resultados
        if (resultados == null) {
            jPanelMain.removeAll();
            JPanel resultadosPanel = new JPanel();

            if (resultados == null) {

                JLabel notResultados = new JLabel();
                notResultados.setText("No hay resultados, por favor cargue resultados \n\n");
                resultadosPanel.add(notResultados);

                JButton cargarFile = new JButton();
                cargarFile.setText("Seleccione el archivo");
                resultadosPanel.add(cargarFile);
                cargarFile.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        cargarFileResultados();
                    }
                });
            }

            jPanelMain.add(resultadosPanel);
            jPanelMain.repaint();
            jPanelMain.revalidate();
        } // Si hay ressultados cargados, llama el método que permite pintar la tabla de resultados
        else {

            int imprimirtabla = 2;
            pintarTablaResultados(imprimirtabla);
        }
    }

    private void pintarMenuDashboardSel() {
        /**
         * Función que se encarga de ajustar los elementos gráficos que
         * componente la opción de navegación de Dashboard de Selecciones Define
         * estilos, etiquetas, iconos que decoran la opción del Menú. Esta
         * opción de Menu permite mostrar los diferentes datos que será
         * extraidos de la información de las selecciones de futbol que fueron
         * cargadas
         */
        btnDashboardSel.setIcon(new ImageIcon(getClass().getResource("/resources/icons/dashboard_selecciones.png")));
        btnDashboardSel.setText("Dash Selecciones");
        btnDashboardSel.setForeground(new java.awt.Color(255, 255, 255));
        btnDashboardSel.setFont(new Font("Courier New", Font.BOLD, 17));

        JLabel vacioDashboardSelecciones = new JLabel();
        jPanelMenuDashboardSel.setBackground(new java.awt.Color(9, 128, 82));
        jPanelMenuDashboardSel.setPreferredSize((new java.awt.Dimension(220, 35)));
        jPanelMenuDashboardSel.setLayout(new BorderLayout(15, 0));
        jPanelMenuDashboardSel.add(vacioDashboardSelecciones, BorderLayout.WEST);
        jPanelMenuDashboardSel.add(btnDashboardSel, BorderLayout.CENTER);
        jPanelMenu.add(jPanelMenuDashboardSel);

        btnDashboardSel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                System.out.println("Dashboard Selecciones");
                accionDashboardSel();
                int recurso = 4;
                excuttabla_contadores(recurso);
            }
        });
    }

    private void accionDashboardSel() {
        jLabelTop.setText("Dashboard Selecciones");

        // Si no hay selecciones cargadas, muestra el botón de carga de selecciones
        if (selecciones == null) {
            accionSelecciones();
        } // Si hay selecciones cargadas, llama el método que permite pintar la tabla clasificada
        else {
            accionDashboardexecut();
            pintarTablaDashboardSelecciones();
        }
    }

    private void pintarTablaDashboardSelecciones() {

        String[] columnNames = {"Continentes", "Cantidad", "Nacionalidades DT", "Cantidad"};

        JTable table = new JTable(selecciones_clasificacion, columnNames);

        table.setRowHeight(30);
        table.setFont(new Font("Courier New", Font.BOLD, 15));

        table.setEnabled(false);

        JPanel seleccionesPanel = new JPanel();
        seleccionesPanel.setLayout(new BoxLayout(seleccionesPanel, BoxLayout.Y_AXIS));
        seleccionesPanel.setPreferredSize((new java.awt.Dimension(620, 410)));
        seleccionesPanel.setMaximumSize(jPanelRight.getPreferredSize());

        JScrollPane scrollPane = new JScrollPane(table);
        seleccionesPanel.add(scrollPane);

        jPanelMain.removeAll();
        jPanelMain.add(seleccionesPanel, BorderLayout.PAGE_START);
        jPanelMain.repaint();
        jPanelMain.revalidate();

    }

    private void accionDashboardexecut() {
        selecciones_clasificacion = new String[selecciones.length][7];

        for (int i = 0; i < selecciones_clasificacion.length; i++) {
            selecciones_clasificacion[i][1] = "0";

        }

        for (int i = 0; i < selecciones.length; i++) {
            int aux = 0;

            switch (selecciones[i][2]) {

                case "Europa":
                    selecciones_clasificacion[0][0] = "Europa";
                    aux = 1 + Integer.parseInt(selecciones_clasificacion[0][1]);
                    selecciones_clasificacion[0][1] = Integer.toString(aux);
                    aux = 0;
                    break;
                case "Asia":
                    selecciones_clasificacion[1][0] = "Asia";
                    aux = 1 + Integer.parseInt(selecciones_clasificacion[1][1]);
                    selecciones_clasificacion[1][1] = Integer.toString(aux);
                    aux = 0;
                    break;
                case "África":
                    selecciones_clasificacion[2][0] = "África";
                    aux = 1 + Integer.parseInt(selecciones_clasificacion[2][1]);
                    selecciones_clasificacion[2][1] = Integer.toString(aux);
                    aux = 0;
                    break;
                case "América del Norte":
                    selecciones_clasificacion[3][0] = "América del Norte";
                    aux = 1 + Integer.parseInt(selecciones_clasificacion[3][1]);
                    selecciones_clasificacion[3][1] = Integer.toString(aux);
                    aux = 0;
                    break;
                case "América Central":
                    selecciones_clasificacion[4][0] = "América Central";
                    aux = 1 + Integer.parseInt(selecciones_clasificacion[4][1]);
                    selecciones_clasificacion[4][1] = Integer.toString(aux);
                    aux = 0;
                    break;
                case "América del Sur":
                    selecciones_clasificacion[5][0] = "América del Sur";
                    aux = 1 + Integer.parseInt(selecciones_clasificacion[5][1]);
                    selecciones_clasificacion[5][1] = Integer.toString(aux);
                    aux = 0;
                    break;
                case "Oceanía":
                    selecciones_clasificacion[6][0] = "Oceanía";
                    aux = 1 + Integer.parseInt(selecciones_clasificacion[6][1]);
                    selecciones_clasificacion[6][1] = Integer.toString(aux);
                    aux = 0;
                    break;

            }

        }
        selecciones_clasificacion[7][0] = "CANTIDAD TOTAL :";
        int total = 0;
        for (int i = 0; i < selecciones_clasificacion.length; i++) {
            total += Integer.parseInt(selecciones_clasificacion[i][1]);

        }
        selecciones_clasificacion[7][1] = Integer.toString(total);

        for (int i = 0; i < selecciones.length; i++) {
            String seleccion = selecciones[i][4];
            boolean existe = false;
            int pos = -1;

            // Buscamos si la selección ya está en el vector de clasificación
            for (int j = 0; j < selecciones_clasificacion.length; j++) {
                if (seleccion.equals(selecciones_clasificacion[j][2])) {
                    // Si ya existe, incrementamos su contador
                    int contador = Integer.parseInt(selecciones_clasificacion[j][3]) + 1;
                    selecciones_clasificacion[j][3] = String.valueOf(contador);
                    existe = true;
                    break;
                } else if (selecciones_clasificacion[j][2] == null && pos == -1) {
                    // Si encontramos un espacio vacío, lo marcamos como posición disponible
                    pos = j;
                }
            }

            // Si no existe, la agregamos al vector de clasificación
            if (!existe) {
                if (pos != -1) {
                    selecciones_clasificacion[pos][2] = seleccion;
                    selecciones_clasificacion[pos][3] = "1";
                } else {
                    selecciones_clasificacion[selecciones_clasificacion.length - 1][2] = seleccion;
                    selecciones_clasificacion[selecciones_clasificacion.length - 1][3] = "1";
                }
            }
        }
        for (int i = 0; i < selecciones_clasificacion.length; i++) {
            if (selecciones_clasificacion[i][1].equals("0")) {
                selecciones_clasificacion[i][1] = "";
            }
        }

        int totaldt = 0;
        for (int i = 0; i < selecciones_clasificacion.length; i++) {
            if (selecciones_clasificacion[i][3] == null) {
                selecciones_clasificacion[i][3] = "0";
            }

            totaldt += Integer.parseInt(selecciones_clasificacion[i][3]);
            if (selecciones_clasificacion[i][3].equals("0")) {

                selecciones_clasificacion[i][2] = "CANTIDAD DT:";
                selecciones_clasificacion[i][3] = Integer.toString(totaldt);

                break;

            }

        }
    }

    private void pintarMenuDashboardRes() {
        /**
         * Función que se encarga de ajustar los elementos gráficos que
         * componente la opción de navegación de Dashboard de Resultados Define
         * estilos, etiquetas, iconos que decoran la opción del Menú. Esta
         * opción de Menu permite mostrar los diferentes datos que será
         * extraidos de la información de los resultados de los partidos que
         * fueron cargados
         */
        btnDashboardRes.setIcon(new ImageIcon(getClass().getResource("/resources/icons/dashboard_resultados.png")));
        btnDashboardRes.setText("Dash Resultados");
        btnDashboardRes.setForeground(new java.awt.Color(255, 255, 255));
        btnDashboardRes.setFont(new Font("Courier New", Font.BOLD, 17));

        JLabel vacioDashboardResultados = new JLabel();
        jPanelMenuDashboardRes.setBackground(new java.awt.Color(9, 128, 82));
        jPanelMenuDashboardRes.setPreferredSize((new java.awt.Dimension(220, 35)));
        jPanelMenuDashboardRes.setLayout(new BorderLayout(15, 0));
        jPanelMenuDashboardRes.add(vacioDashboardResultados, BorderLayout.WEST);
        jPanelMenuDashboardRes.add(btnDashboardRes, BorderLayout.CENTER);
        jPanelMenu.add(jPanelMenuDashboardRes);

        btnDashboardRes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                System.out.println("Dashboard Resultados");
                accionDashboardRes();
                int recurso = 5;
                excuttabla_contadores(recurso);
            }
        });
    }

    private void accionDashboardRes() {
        jLabelTop.setText("Dashboard Resultados");

        // Si no hay selecciones cargadas, muestra el botón de carga de selecciones
        if (resultados == null) {
            accionResultados();
        } // Si hay selecciones cargadas, llama el método que permite pintar la tabla clasificada
        else {
            executaccionDashboard();
            int imprimirtabla = 1;
            pintarResultadodash(imprimirtabla);
        }
    }

    private void executaccionDashboard() {
        resultados_clasificacion = new String[resultados.length][7];
        pm_golesxpartido = new String[resultados.length][3];
        int total_partidos = 0, gandores = 0, empate = 0;
        double promtemp = 0;
        int aux = 5, aux2 = 9, contador = 0, contador2 = 10;
        for (int i = 0; i < resultados.length; i++) {

            //se guaradan PROMEDIOS
            DecimalFormat df = new DecimalFormat("#.#");
            promtemp = (Double.parseDouble(resultados[i][5]) + Double.parseDouble(resultados[i][6])) / 2;
            pm_golesxpartido[i][0] = resultados[i][1];
            pm_golesxpartido[i][1] = resultados[i][2];
            pm_golesxpartido[i][2] = df.format(promtemp);
            promtemp = 0;

            //se guaradan CANTIDAD TOTAL DE PARTIDOS
            total_partidos++;
            resultados_clasificacion[0][0] = "N° de partidos";
            resultados_clasificacion[0][1] = Integer.toString(total_partidos);

            //se guaradan PARTIDOS CON MAS GOLES
            resultados_clasificacion[4][0] = "Patidos con MAS goles";
            resultados_clasificacion[4][1] = "Goles";
            for (int j = 0; j < resultados.length; j++) {

                int sumatep = (Integer.parseInt(resultados[j][5]) + Integer.parseInt(resultados[j][6]));
                if (sumatep >= contador) {
                    contador = sumatep;
                    sumatep = 0;
                }

            }

            int sumatep = (Integer.parseInt(resultados[i][5]) + Integer.parseInt(resultados[i][6]));

            if (sumatep >= contador) {
                resultados_clasificacion[aux][1] = resultados[i][5];
                resultados_clasificacion[aux + 1][1] = resultados[i][6];
                resultados_clasificacion[aux][0] = resultados[i][1];
                resultados_clasificacion[aux + 1][0] = resultados[i][2];
                aux += 2;

            }

            //se guaradan PARTIDOS CON MENOS GOLES
            for (int k = 0; k < resultados_clasificacion.length; k++) {

                if (resultados_clasificacion[k][0] == null) {

                    resultados_clasificacion[aux + 1][0] = "Patidos con MENOS goles";
                    resultados_clasificacion[aux + 1][1] = "Goles";
                    for (int j = 0; j < resultados.length; j++) {

                        int restatep = (Integer.parseInt(resultados[j][5]) + Integer.parseInt(resultados[j][6]));
                        if (restatep <= contador2) {
                            contador2 = restatep;
                            restatep = 0;

                        }
                    }

                    int restatep = (Integer.parseInt(resultados[i][5]) + Integer.parseInt(resultados[i][6]));

                    if (restatep == contador2) {

                        resultados_clasificacion[aux2 + 2][1] = resultados[i][5];
                        resultados_clasificacion[aux2 + 3][1] = resultados[i][6];
                        resultados_clasificacion[aux2 + 2][0] = resultados[i][1];
                        resultados_clasificacion[aux2 + 3][0] = resultados[i][2];
                        aux2 += 2;
                        break;
                    }
                }
            }

            //se guaradan el numero de partidos con un ganador y empate
            if (Integer.parseInt(resultados[i][5]) != Integer.parseInt(resultados[i][6])) {
                gandores++;
                resultados_clasificacion[1][0] = "Partidos con un Ganador";
                resultados_clasificacion[1][1] = Integer.toString(gandores);
            } else if (Integer.parseInt(resultados[i][5]) == Integer.parseInt(resultados[i][6])) {
                empate++;
                resultados_clasificacion[2][0] = "Partidos con un Empate";
                resultados_clasificacion[2][1] = Integer.toString(empate);
            }

        }

        executselecionesxgoles();
        executgrupos();
        executpuntosdeseleciones();

    }

    private void executgrupos() {
        clasificacion_grupos = new String[resultados.length][8];

        int cont = 0;
        for (int i = 0; i < resultados.length; i++) {
            switch (resultados[i][0]) {

                case "A":
                    cont = 0;
                    break;
                case "B":
                    cont = 1;
                    break;
                case "C":
                    cont = 2;
                    break;
                case "D":
                    cont = 3;
                    break;
                case "E":
                    cont = 4;
                    break;
                case "F":
                    cont = 5;
                    break;
                case "G":
                    cont = 6;
                    break;
                case "H":
                    cont = 7;
                    break;
            }

            //BUSCADOR
            if (true) {

                String seleccion = resultados[i][1];
                boolean existe = false;
                int pos = -1;
                // Buscamos si la selección exite
                for (int j = 0; j < clasificacion_grupos.length; j++) {
                    if (seleccion.equals(clasificacion_grupos[j][cont])) { // la columna
                        // Si ya existe, incrementamos su contador
                        existe = true;
                        break;
                    } else if (clasificacion_grupos[j][cont] == null && pos == -1) { // la columna
                        // Si encontramos un espacio vacío, lo marcamos como posición disponible
                        pos = j;
                    }

                    // Si no existe, la agregamos al vector de clasificación
                    if (!existe) {
                        if (pos != -1) {
                            clasificacion_grupos[pos][cont] = seleccion;    // la columna
                        } else {
                            clasificacion_grupos[clasificacion_grupos.length - 1][cont] = seleccion;// la columna
                        }
                    }
                }
            }

            String seleccion = resultados[i][2];
            boolean existe = false;
            int pos = -1;
            // Buscamos si la selección exite
            for (int j = 0; j < clasificacion_grupos.length; j++) {
                if (seleccion.equals(clasificacion_grupos[j][cont])) { // la columna
                    // Si ya existe, incrementamos su contador
                    existe = true;
                    break;
                } else if (clasificacion_grupos[j][cont] == null && pos == -1) { // la columna
                    // Si encontramos un espacio vacío, lo marcamos como posición disponible
                    pos = j;
                }
            }
            // Si no existe, la agregamos al vector de clasificación
            if (!existe) {
                if (pos != -1) {
                    clasificacion_grupos[pos][cont] = seleccion;    // la columna
                } else {
                    clasificacion_grupos[clasificacion_grupos.length - 1][cont] = seleccion;// la columna

                }

            }
        }
    }

    private void executpuntosdeseleciones() {
        //Busca en cada partido el ganador y leda 3 puntos cada vez que gana

        for (int i = 0; i < resultados.length; i++) {
            int equipo1 = Integer.parseInt(resultados[i][5]);
            int equipo2 = Integer.parseInt(resultados[i][6]);

            if (equipo1 > equipo2) {

                String seleccion = resultados[i][1];
                boolean existe = false;
                int pos = -1;

                // Buscamos si la selección existe
                for (int j = 0; j < selecionesxgoles.length; j++) {
                    if (seleccion.equals(selecionesxgoles[j][2])) {
                        // Si ya existe, incrementamos su contador
                        int contador = Integer.parseInt(selecionesxgoles[j][3]) + 3;
                        selecionesxgoles[j][3] = String.valueOf(contador);
                        existe = true;
                        break;
                    } else if (selecionesxgoles[j][2] == null && pos == -1) {
                        // Si encontramos un espacio vacío, lo marcamos como posición disponible
                        pos = j;
                    }
                }

                // Si no existe, la agregamos al vector de clasificación
                if (!existe) {
                    if (pos != -1) {
                        selecionesxgoles[pos][2] = seleccion;
                        selecionesxgoles[pos][3] = "3";  // Asignamos 3 puntos al equipo1 que ganó
                    } else {
                        selecionesxgoles[selecionesxgoles.length - 1][0] = seleccion;
                        selecionesxgoles[selecionesxgoles.length - 1][1] = "0";
                    }
                }
            }

            if (equipo1 < equipo2) {
                String seleccion = resultados[i][2];
                boolean existe = false;
                int pos = -1;

                // Buscamos si la selección existe
                for (int j = 0; j < selecionesxgoles.length; j++) {
                    if (seleccion.equals(selecionesxgoles[j][2])) {
                        // Si ya existe, incrementamos su contador
                        int contador = Integer.parseInt(selecionesxgoles[j][3]) + 3;
                        selecionesxgoles[j][3] = String.valueOf(contador);
                        existe = true;
                        break;
                    } else if (selecionesxgoles[j][2] == null && pos == -1) {
                        // Si encontramos un espacio vacío, lo marcamos como posición disponible
                        pos = j;
                    }
                }

                // Si no existe, la agregamos al vector de clasificación
                if (!existe) {
                    if (pos != -1) {
                        selecionesxgoles[pos][2] = seleccion;
                        selecionesxgoles[pos][3] = "3";  // Asignamos 3 puntos al equipo1 que ganó
                    } else {
                        selecionesxgoles[selecionesxgoles.length - 1][0] = seleccion;
                        selecionesxgoles[selecionesxgoles.length - 1][1] = "0";
                    }
                }
            }
        }

    }

    private void executselecionesxgoles() {

        selecionesxgoles = new String[resultados.length][6];

        for (int i = 0; i < selecionesxgoles.length; i++) {
            selecionesxgoles[i][1] = "0";

        }

        for (int i = 0; i < resultados.length; i++) {
            String seleccion = resultados[i][1];
            boolean existe = false;
            int pos = -1;

            // Buscamos si la selección exite
            for (int j = 0; j < selecionesxgoles.length; j++) {
                if (seleccion.equals(selecionesxgoles[j][0])) {
                    // Si ya existe, incrementamos su contador
                    int contador = Integer.parseInt(selecionesxgoles[j][1]) + Integer.parseInt(resultados[i][5]);
                    selecionesxgoles[j][1] = String.valueOf(contador);
                    existe = true;
                    break;
                } else if (selecionesxgoles[j][0] == null && pos == -1) {
                    // Si encontramos un espacio vacío, lo marcamos como posición disponible
                    pos = j;
                }
            }

            // Si no existe, la agregamos al vector de clasificación
            if (!existe) {
                if (pos != -1) {
                    selecionesxgoles[pos][0] = seleccion;
                    selecionesxgoles[pos][1] = resultados[i][5];
                } else {
                    selecionesxgoles[selecionesxgoles.length - 1][0] = seleccion;
                    selecionesxgoles[selecionesxgoles.length - 1][1] = "1";
                }
            }
        }
        for (int i = 0; i < resultados.length; i++) {
            String seleccion = resultados[i][2];
            boolean existe = false;
            int pos = -1;

            // Buscamos si la selección exite
            for (int j = 0; j < selecionesxgoles.length; j++) {
                if (seleccion.equals(selecionesxgoles[j][0])) {
                    // Si ya existe, incrementamos su contador
                    int contador = Integer.parseInt(selecionesxgoles[j][1]) + Integer.parseInt(resultados[i][6]);
                    selecionesxgoles[j][1] = String.valueOf(contador);
                    existe = true;
                    break;
                } else if (selecionesxgoles[j][0] == null && pos == -1) {
                    // Si encontramos un espacio vacío, lo marcamos como posición disponible
                    pos = j;
                }
            }
            // Si no existe, la agregamos al vector de clasificación
            if (!existe) {
                if (pos != -1) {
                    selecionesxgoles[pos][0] = seleccion;
                    selecionesxgoles[pos][1] = resultados[i][6];
                } else {
                    selecionesxgoles[selecionesxgoles.length - 1][0] = seleccion;
                    selecionesxgoles[selecionesxgoles.length - 1][1] = "1";
                }
            }
        }

        int filas = selecionesxgoles.length;
// Ordenar el vector de mayor a menor utilizando el algoritmo de burbuja
        for (int i = 0; i < filas - 1; i++) {
            for (int j = 0; j < filas - i - 1; j++) {
                int valorActual = Integer.parseInt(selecionesxgoles[j][1]);
                int valorSiguiente = Integer.parseInt(selecionesxgoles[j + 1][1]);

                if (valorActual < valorSiguiente) {
                    // Intercambiar las filas en el vector
                    String[] temp = selecionesxgoles[j];
                    selecionesxgoles[j] = selecionesxgoles[j + 1];
                    selecionesxgoles[j + 1] = temp;
                }
            }
        }

        //Filtro por continetes
        for (int i = 0; i < resultados.length; i++) {
            String Continete = resultados[i][3];
            boolean existe = false;
            int pos = -1;

            // Buscamos si la selección exite
            for (int j = 0; j < selecionesxgoles.length; j++) {
                if (Continete.equals(selecionesxgoles[j][4])) {
                    // Si ya existe, incrementamos su contador
                    int contador = Integer.parseInt(selecionesxgoles[j][5]) + Integer.parseInt(resultados[i][5]);
                    selecionesxgoles[j][5] = String.valueOf(contador);
                    existe = true;
                    break;
                } else if (selecionesxgoles[j][4] == null && pos == -1) {
                    // Si encontramos un espacio vacío, lo marcamos como posición disponible
                    pos = j;
                }
            }

            // Si no existe, la agregamos al vector de clasificación
            if (!existe) {
                if (pos != -1) {
                    selecionesxgoles[pos][4] = Continete;
                    selecionesxgoles[pos][5] = resultados[i][5];
                } else {
                    selecionesxgoles[selecionesxgoles.length - 1][4] = Continete;
                    selecionesxgoles[selecionesxgoles.length - 1][5] = "1";
                }
            }
        }
        for (int i = 0; i < resultados.length; i++) {
            String seleccion = resultados[i][4];
            boolean existe = false;
            int pos = -1;

            // Buscamos si la selección exite
            for (int j = 0; j < selecionesxgoles.length; j++) {
                if (seleccion.equals(selecionesxgoles[j][4])) {
                    // Si ya existe, incrementamos su contador
                    int contador = Integer.parseInt(selecionesxgoles[j][5]) + Integer.parseInt(resultados[i][6]);
                    selecionesxgoles[j][5] = String.valueOf(contador);
                    existe = true;
                    break;
                } else if (selecionesxgoles[j][4] == null && pos == -1) {
                    // Si encontramos un espacio vacío, lo marcamos como posición disponible
                    pos = j;
                }
            }
            // Si no existe, la agregamos al vector de clasificación
            if (!existe) {
                if (pos != -1) {
                    selecionesxgoles[pos][4] = seleccion;
                    selecionesxgoles[pos][5] = resultados[i][6];
                } else {
                    selecionesxgoles[selecionesxgoles.length - 1][4] = seleccion;
                    selecionesxgoles[selecionesxgoles.length - 1][5] = "1";
                }
            }
        }

        for (int i = 0; i < selecionesxgoles.length; i++) {

            if (selecionesxgoles[i][0] == null) {
                selecionesxgoles[i][1] = null;
            }

        }

    }

    private void pintarPanelIzquierdo() {
        /**
         * Función que permite darle estilos y agregar los componentes gráficos
         * del contendor de la parte izquierda de la interfaz, dónde se
         * visulaiza el menú de navegaación
         */
        // Se elimina el color de fondo del panel del menú
        jPanelMenu.setOpaque(false);

        // Se agrega un border izquierdo, de color blanco para diferenciar el panel de menú del panel de contenido
        jPanelLeft.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 3, Color.WHITE));

        // Se define un BoxLayot de manera vertical para los elementos del panel izquierdo
        jPanelLeft.setLayout(new BoxLayout(jPanelLeft, BoxLayout.Y_AXIS));
        jPanelLeft.setBackground(new java.awt.Color(7, 88, 57));
        getContentPane().add(jPanelLeft, java.awt.BorderLayout.LINE_START);
        jPanelLeft.add(jPanelMenu);
        jPanelLeft.setPreferredSize((new java.awt.Dimension(220, 540)));
        jPanelLeft.setMaximumSize(jPanelLeft.getPreferredSize());
    }

    public void cargarFileSelecciones() {
        /**
         * Función que permite leer un archivo y procesar el contenido que tiene
         * en cada una de sus líneas El contenido del archivo es procesado y
         * cargado en la matriz de selecciones. Una vez la información se carga
         * en la atriz, se hace un llamado a la función pintarTablaSelecciones()
         * que se encarga de pintar en la interfaz una tabla con la información
         * almacenada en la matriz de selecciones
         */
        JFileChooser cargarFile = new JFileChooser();
        cargarFile.showOpenDialog(cargarFile);

        Scanner entrada = null;
        try {

            // Se obtiene la ruta del archivo seleccionado
            //String ruta = cargarFile.getSelectedFile().getAbsolutePath();
            String ruta = "C:\\Users\\eddym\\OneDrive\\Documentos\\NetBeansProjects\\ProyectoMundial\\src\\proyectomundial\\files\\selecciones.csv";

            // Se obtiene el archivo y se almancena en la variable f
            File f = new File(ruta);
            entrada = new Scanner(f);

            // Se define las dimensiones de la matriz de selecciones
            selecciones = new String[32][5];

            // Permite que el sistema se salte la léctura de los encabzados del archivo CSV
            entrada.nextLine();

            int i = 0;
            // Se leen cada unas de las líneas del archivo
            while (entrada.hasNext()) {

                String line = entrada.nextLine();
                String[] columns = line.split(",");

                for (int j = 0; j < columns.length; j++) {
                    selecciones[i][j] = columns[j];
                }
                if (selecciones.length - 1 == i) {
                    System.out.println(i + 1 + " Selecciones Cargadas");

                }
                i++;

            }
            int imprimirtablafiltro = 2;
            pintarTablaSelecciones(imprimirtablafiltro);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (entrada != null) {
                entrada.close();
            }
        }
    }

    public void pintarTablaSelecciones(int imprimirtabla) {
        /**
         * Función que se encarga de pinta la tabla con la información de las
         * selelceciones que fue cargada previamente La tabla tiene definido un
         * encabezado con las siguentes columnas: {"ID","Selección",
         * "Continente", "DT", "Nacionalidad DT"} Columnas que se corresponden
         * son la información que fue leida desde el archivo csv
         */
        String[] columnNames = {"ID", "Selección", "Continente", "DT", "Nacionalidad DT"};

        JTable table = new JTable();
        table.setRowHeight(30);

        if (imprimirtabla == 1) {
            table = new JTable(filtro, columnNames);
        } else if (imprimirtabla == 2) {
            table = new JTable(selecciones, columnNames);
        }
        table.setFont(new Font("Courier New", Font.BOLD, 11));
        table.setEnabled(false);

        JPanel form = new JPanel();
        form.setLayout(new GridLayout(3, 1, 0, 0));

        JLabel label = new JLabel();
        label.setText("Busqueda de Equipos");
        form.add(label);

        JTextField field = new JTextField();
        form.add(field);

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(1, 2, 30, 0));

        JButton buscar = new JButton();
        buscar.setText("Buscar");
        panelBotones.add(buscar);
        buscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String texto = field.getText();
                String fuente = "selecciones";
                filtrodebusqueda(texto, fuente);
                filtro = null;
            }
        });

        JButton limpiar = new JButton();
        limpiar.setText("Ver Todos");
        panelBotones.add(limpiar);
        form.add(panelBotones);
        limpiar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int imprimirtabla = 2;
                pintarTablaSelecciones(imprimirtabla);
            }
        });

        JPanel seleccionesPanel = new JPanel();
        seleccionesPanel.setLayout(new BoxLayout(seleccionesPanel, BoxLayout.Y_AXIS));
        seleccionesPanel.setPreferredSize((new java.awt.Dimension(620, 410)));
        seleccionesPanel.setMaximumSize(jPanelRight.getPreferredSize());

        JScrollPane scrollPane = new JScrollPane(table);
        seleccionesPanel.add(form);
        seleccionesPanel.add(scrollPane);

        jPanelMain.removeAll();
        jPanelMain.add(seleccionesPanel, BorderLayout.PAGE_START);
        jPanelMain.repaint();
        jPanelMain.revalidate();
    }

    public void cargarFileResultados() {
        /**
         * Función que tiene la lógica que permite leer un archivo CSV de
         * resultados y cargarlo sobre la matriz resultados que se tiene
         * definida cómo variable global. Luego de cargar los datos en la
         * matriz, se llama la función pintarTablaResultados() que se encarga de
         * visulizar el contenido de la matriz en un componente gráfico de tabla
         */
        JFileChooser cargarFile = new JFileChooser();
        cargarFile.showOpenDialog(cargarFile);

        Scanner entrada = null;
        try {
            // Se obtiene la ruta del archivo seleccionado
            //String ruta = cargarFile.getSelectedFile().getAbsolutePath();
            String ruta = "C:\\Users\\eddym\\OneDrive\\Documentos\\NetBeansProjects\\ProyectoMundial\\src\\proyectomundial\\files\\partidos2018.csv";
            // Se obtiene el archivo y se almancena en la variable f
            File f = new File(ruta);
            entrada = new Scanner(f);

            // Se define las dimensiones de la matriz de selecciones
            resultados = new String[48][7];
            entrada.nextLine();

            int i = 0;
            // Se iteran cada una de las líneas del archivo
            while (entrada.hasNext()) {
                String line = entrada.nextLine();
                String[] columns = line.split(",");

                for (int j = 0; j < columns.length; j++) {
                    resultados[i][j] = columns[j];
                }
                if (resultados.length - 1 == i) {
                    System.out.println(i + 1 + " Partidos Cargados");

                }
                i++;
            }
            int imprimirtabla = 2;
            pintarTablaResultados(imprimirtabla);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (entrada != null) {
                entrada.close();
            }
        }
    }

    public void pintarResultadodash(int imprimirtabla) {
        /**
         * Función que se encarga de pintar la tabla con la información de los
         * resultados que fue cargada previamente La tabla tiene definido un
         * encabezado con las siguentes columnas: {"Grupo","Local", "Visitante",
         * "Continente L", "Continente V", "Goles L", "Goles V"} Columnas que se
         * corresponden son la información que fue leida desde el archivo csv
         */
        String[] columnNames = {};
        JTable table = new JTable();
        if (imprimirtabla == 1) {
            columnNames = new String[]{"N°", "cantidad"};
            table = new JTable(resultados_clasificacion, columnNames);
        }
        if (imprimirtabla == 2) {
            columnNames = new String[]{"selecciones mas a menos:", "goles", "Selección más puntos a menos:", "puntos", "Continentes mas a menos goles:", "goles",};
            table = new JTable(selecionesxgoles, columnNames);
        }
        if (imprimirtabla == 3) {
            columnNames = new String[]{"Grupo A", "Grupo B", "Grupo C", "Grupo D", "Grupo E", "Grupo F", "Grupo G", "Grupo H"};
            table = new JTable(clasificacion_grupos, columnNames);
        }
        if (imprimirtabla == 4) {
            columnNames = new String[]{"local", "visitante", "promedio goles"};
            table = new JTable(pm_golesxpartido, columnNames);
        }

        table.setRowHeight(30);

        table.setEnabled(false);

        table.setFont(new Font("Courier New", Font.BOLD, 13));

        JPanel form = new JPanel();
        form.setLayout(new GridLayout(1, 1, 0, 0));

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(1, 1, 1, 1));

        JButton principal = new JButton();
        principal.setText("Principal");
        panelBotones.add(principal);
        form.add(panelBotones);
        principal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int imprimirtabla = 1;
                pintarResultadodash(imprimirtabla);
            }
        });

        JButton seleciones = new JButton();
        seleciones.setText("Seleciones Goles y Puntos");
        panelBotones.add(seleciones);
        form.add(panelBotones);
        seleciones.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int imprimirtabla = 2;
                pintarResultadodash(imprimirtabla);
            }
        });

        JButton grupos = new JButton();
        grupos.setText("Grupos");
        panelBotones.add(grupos);
        form.add(panelBotones);
        grupos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int imprimirtabla = 3;
                pintarResultadodash(imprimirtabla);
            }
        });
        JButton promedio = new JButton();
        promedio.setText("Promedio Goles");
        panelBotones.add(promedio);
        form.add(panelBotones);
        promedio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int imprimirtabla = 4;
                pintarResultadodash(imprimirtabla);
            }
        });

        JPanel resultadosPanel = new JPanel();
        resultadosPanel.setLayout(new BoxLayout(resultadosPanel, BoxLayout.Y_AXIS));
        resultadosPanel.setPreferredSize((new java.awt.Dimension(620, 410)));
        resultadosPanel.setMaximumSize(jPanelRight.getPreferredSize());

        JScrollPane scrollPane = new JScrollPane(table);
        resultadosPanel.add(form);
        resultadosPanel.add(scrollPane);

        jPanelMain.removeAll();
        jPanelMain.add(resultadosPanel, BorderLayout.PAGE_START);
        jPanelMain.repaint();
        jPanelMain.revalidate();
    }

    public void pintarTablaResultados(int imprimirtabla) {
        /**
         * Función que se encarga de pintar la tabla con la información de los
         * resultados que fue cargada previamente La tabla tiene definido un
         * encabezado con las siguentes columnas: {"Grupo","Local", "Visitante",
         * "Continente L", "Continente V", "Goles L", "Goles V"} Columnas que se
         * corresponden son la información que fue leida desde el archivo csv
         */
        String[] columnNames = {"Grupo", "Local", "Visitante", "Continente L", "Continente V", "Goles L", "Goles V"};
        JTable table = new JTable();
        table.setRowHeight(30);

        if (imprimirtabla == 1) {
            table = new JTable(filtro, columnNames);
        } else if (imprimirtabla == 2) {
            table = new JTable(resultados, columnNames);
        }

        table.setFont(new Font("Courier New", Font.BOLD, 11));
        table.setEnabled(false);

        JPanel form = new JPanel();
        form.setLayout(new GridLayout(3, 1, 0, 0));

        JLabel label = new JLabel();
        label.setText("Busqueda de Equipos");
        form.add(label);

        JTextField field = new JTextField();
        form.add(field);

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(1, 2, 30, 0));

        JButton buscar = new JButton();
        buscar.setText("Buscar");
        panelBotones.add(buscar);
        buscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String texto = field.getText();
                String fuente = "resultados";
                filtrodebusqueda(texto, fuente);
                filtro = null;
            }
        });

        JButton limpiar = new JButton();
        limpiar.setText("Ver Todos");
        panelBotones.add(limpiar);
        form.add(panelBotones);
        limpiar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int imprimirtabla = 2;
                pintarTablaResultados(imprimirtabla);
            }
        });

        JPanel resultadosPanel = new JPanel();
        resultadosPanel.setLayout(new BoxLayout(resultadosPanel, BoxLayout.Y_AXIS));
        resultadosPanel.setPreferredSize((new java.awt.Dimension(620, 410)));
        resultadosPanel.setMaximumSize(jPanelRight.getPreferredSize());

        JScrollPane scrollPane = new JScrollPane(table);
        resultadosPanel.add(form);
        resultadosPanel.add(scrollPane);

        jPanelMain.removeAll();
        jPanelMain.add(resultadosPanel, BorderLayout.PAGE_START);
        jPanelMain.repaint();
        jPanelMain.revalidate();
    }

    private void pintarPanelDerecho() {
        /**
         * Función que permite darle estilos y agregar los componentes gráficos
         * del contendor de la parte derecha de la interfaz, dónde se visulaiza
         * de manera dinámica el contenido de cada una de las funciones que
         * puede realizar el usuario sobre la aplicación.
         */
        // Define las dimensiones del panel
        jPanelMain.setPreferredSize((new java.awt.Dimension(620, 420)));
        jPanelMain.setMaximumSize(jPanelLabelTop.getPreferredSize());

        getContentPane().add(jPanelRight, java.awt.BorderLayout.CENTER);
        jPanelRight.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        jPanelRight.add(jPanelLabelTop, BorderLayout.LINE_START);
        jPanelRight.add(jPanelMain);
        jPanelRight.setPreferredSize((new java.awt.Dimension(620, 540)));
        jPanelRight.setMaximumSize(jPanelRight.getPreferredSize());
    }

    private void pintarLabelTop() {
        /**
         * Función que permite pinta la barra azul del contenedor de contenidos.
         * Barra azul que permite indicar en que sección que se encuentra
         * navegando el usuario.
         */
        jLabelTop = new JLabel();
        jLabelTop.setFont(new java.awt.Font("Liberation Sans", 1, 36)); // NOI18N
        jLabelTop.setForeground(new java.awt.Color(241, 241, 241));
        jLabelTop.setText("Home");
        jLabelTop.setFont(new Font("Courier New", Font.BOLD, 30));

        JLabel vacioTopLabel = new JLabel();
        jPanelLabelTop.setLayout(new BorderLayout(15, 0));
        jPanelLabelTop.add(vacioTopLabel, BorderLayout.WEST);
        jPanelLabelTop.setBackground(new java.awt.Color(6, 75, 49));
        jPanelLabelTop.add(jLabelTop, BorderLayout.CENTER);
        jPanelLabelTop.setPreferredSize((new java.awt.Dimension(620, 120)));
        jPanelLabelTop.setMaximumSize(jPanelLabelTop.getPreferredSize());
    }

    private void menualeatorio() {
        /**
         * Función que se encarga de ajustar los elementos gráficos que
         * componente la opción de navegación del HOME Define estilos,
         * etiquetas, iconos que decoran la opción del Menú. Esta opción de Menu
         * permite mostrar la página de bienvenida de la aplicación
         */
        btnpika.setIcon(new ImageIcon(getClass().getResource("/resources/icons/menualeatorio.png"))); // NOI18N
        btnpika.setText("Aleatorio pika");
        btnpika.setForeground(new java.awt.Color(255, 255, 255));
        btnpika.setFont(new Font("Courier New", Font.BOLD, 17));

        JLabel vacioHome = new JLabel();
        jPanelpika.setBackground(new java.awt.Color(9, 128, 82));
        jPanelpika.setPreferredSize((new java.awt.Dimension(220, 35)));
        jPanelpika.setLayout(new BorderLayout(15, 0));
        jPanelpika.add(vacioHome, BorderLayout.WEST);
        jPanelpika.add(btnpika, BorderLayout.CENTER);
        jPanelMenu.add(jPanelpika);

        btnpika.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                System.out.println("Aleatorio pika");
                accionmenualeatorio();
            }
        });

    }

    public void accionmenualeatorio() {

        jLabelTop.setText("Aleatorio pika");
        menualeatorio = new String[11][10];
        pintarmenualeatorio();

    }

    public void excutleatorio() {

        contador++;

        for (int i = 0; i < menualeatorio.length; i++) {
            for (int j = 0; j < menualeatorio[0].length; j++) {

                Random rand = new Random();
                int numAleatorio = rand.nextInt(101); // Devuelve un número entre 0 y 100 (ambos inclusive)
                menualeatorio[i][j] = Integer.toString(numAleatorio);
                pintarmenualeatorio();
            }

        }

    }

    public void pintarmenualeatorio() {

        String[] columnNames = {"", "", "", "", "", "", "", "", "", ""};
        JTable table = new JTable(menualeatorio, columnNames);
        table.setRowHeight(30);
        table.setFont(new Font("Courier New", Font.BOLD, 30));

        table.setEnabled(false);

        JPanel form = new JPanel();
        form.setLayout(new GridLayout(2, 1, 1, 1));

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(1, 2, 30, 0));

        JButton aleatorio = new JButton();
        aleatorio.setText("Click para generar numero aleatorios");
        panelBotones.add(aleatorio);
        form.add(panelBotones);
        aleatorio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                excutleatorio();
            }
        });

        JButton botoncontador = new JButton();
        String convetidor = Integer.toString(contador);
        botoncontador.setText(convetidor);
        panelBotones.add(botoncontador);
        form.add(panelBotones);
        botoncontador.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                contador = 0;
                menualeatorio = null;
                accionmenualeatorio();
            }
        });

        JPanel seleccionesPanel = new JPanel();
        seleccionesPanel.setLayout(new BoxLayout(seleccionesPanel, BoxLayout.Y_AXIS));
        seleccionesPanel.setPreferredSize((new java.awt.Dimension(620, 410)));
        seleccionesPanel.setMaximumSize(jPanelRight.getPreferredSize());

        JScrollPane scrollPane = new JScrollPane(table);
        seleccionesPanel.add(form);
        seleccionesPanel.add(scrollPane);
        jPanelMain.removeAll();
        jPanelMain.add(seleccionesPanel, BorderLayout.PAGE_START);
        jPanelMain.repaint();
        jPanelMain.revalidate();
    }

    private void tabla_contadores() {

        btncontador.setIcon(new ImageIcon(getClass().getResource("/resources/icons/menualeatorio.png"))); // NOI18N
        btncontador.setText("Contador Clicks");
        btncontador.setForeground(new java.awt.Color(255, 255, 255));
        btncontador.setFont(new Font("Courier New", Font.BOLD, 17));

        JLabel vacioHome = new JLabel();
        jPanelcontador.setBackground(new java.awt.Color(9, 128, 82));
        jPanelcontador.setPreferredSize((new java.awt.Dimension(220, 35)));
        jPanelcontador.setLayout(new BorderLayout(15, 0));
        jPanelcontador.add(vacioHome, BorderLayout.WEST);
        jPanelcontador.add(btncontador, BorderLayout.CENTER);
        jPanelMenu.add(jPanelcontador);

        btncontador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                System.out.println("Contador Clicks");
                accionmenutabla_contadores();
            }
        });

    }

    public void accionmenutabla_contadores() {

        for (int i = 0; i < tabla_contador.length; i++) {

            tabla_contador[i][1] = "0";

        }
        jLabelTop.setText("Contador Clicks");

        tabla_contador[0][0] = "Inicio";
        tabla_contador[1][0] = "Seleciones";
        tabla_contador[2][0] = "Resultados";
        tabla_contador[3][0] = "Dash Seleciones";
        tabla_contador[4][0] = "Dash Resultados";
        int recurso = 0;
        excuttabla_contadores(recurso);
        pintarmenutabla_contadores();

    }

    public void excuttabla_contadores(int recurso) {
        if (recurso == 1) {
            c_home++;
        }
        if (recurso == 2) {
            c_selecciones++;
        }
        if (recurso == 3) {
            c_resultados++;
        }
        if (recurso == 4) {
            c_dseleciones++;
        }
        if (recurso == 5) {
            c_dresultados++;
        }

        tabla_contador[0][1] = Integer.toString(c_home);
        tabla_contador[1][1] = Integer.toString(c_selecciones);
        tabla_contador[2][1] = Integer.toString(c_resultados);
        tabla_contador[3][1] = Integer.toString(c_dseleciones);
        tabla_contador[4][1] = Integer.toString(c_dresultados);

    }

    public void pintarmenutabla_contadores() {

        String[] columnNames = {"Accion", "Clicks"};
        JTable table = new JTable(tabla_contador, columnNames);
        table.setRowHeight(30);
        table.setFont(new Font("Courier New", Font.BOLD, 30));

        table.setEnabled(false);

        JPanel seleccionesPanel = new JPanel();
        seleccionesPanel.setLayout(new BoxLayout(seleccionesPanel, BoxLayout.Y_AXIS));
        seleccionesPanel.setPreferredSize((new java.awt.Dimension(620, 410)));
        seleccionesPanel.setMaximumSize(jPanelRight.getPreferredSize());

        JScrollPane scrollPane = new JScrollPane(table);

        seleccionesPanel.add(scrollPane);
        jPanelMain.removeAll();
        jPanelMain.add(seleccionesPanel, BorderLayout.PAGE_START);
        jPanelMain.repaint();
        jPanelMain.revalidate();
    }

    public void filtrodebusqueda(String buscar, String fuente) {

        String busqueda = buscar.toLowerCase();
        int aux = 0;
        if (fuente.equals("selecciones")) {
            filtro = new String[selecciones.length][selecciones[0].length];
            for (int i = 0; i < selecciones.length; i++) {
                for (int j = 0; j < selecciones[i].length; j++) {
                    if (selecciones[i][j].toLowerCase().startsWith(busqueda.toLowerCase())) {

                        for (int k = 0; k < selecciones[i].length; k++) {
                            filtro[aux][k] = selecciones[i][k];

                        }
                        aux++;
                        break;
                    }
                }

            }
            int imprimirtablafiltro = 1;

            pintarTablaSelecciones(imprimirtablafiltro);
        }
        if (fuente.equals("resultados")) {
            filtro = new String[resultados.length][resultados[0].length];
            for (int i = 0; i < resultados.length; i++) {
                for (int j = 0; j < resultados[i].length; j++) {
                    if (resultados[i][j].toLowerCase().startsWith(busqueda.toLowerCase())) {

                        for (int k = 0; k < resultados[i].length; k++) {
                            filtro[aux][k] = resultados[i][k];

                        }
                        aux++;
                        break;
                    }
                }

            }
            int imprimirtablafiltro = 1;

            pintarTablaResultados(imprimirtablafiltro);
        }

    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIManual().setVisible(true);
            }
        });
    }
}
