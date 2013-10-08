package controleatleta;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class CadastroFutebolista extends javax.swing.JFrame {

    private final byte SEXO_MASCULINO_INDICE = 0;
    private final byte SEXO_FEMININO_INDICE = 1;
    private final char SEXO_MASCULINO_VALOR = 'M';
    private final char SEXO_FEMININO_VALOR = 'F';
    private final byte CATEGORIA_AMADOR_INDICE = 0;
    private final byte CATEGORIA_PROFISSIONAL_INDICE = 1;
    private final char CATEGORIA_AMADOR_VALOR = 'A';
    private final char CATEGORIA_PROFISSIONAL_VALOR = 'P';
    private final byte PERNABOA_DESTRO_INDICE = 0;
    private final byte PERNABOA_CANHOTO_INDICE = 1;
    private final char PERNABOA_DESTRO_VALOR = 'D';
    private final char PERNABOA_CANHOTO_VALOR = 'C';
    private DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private ControleFutebolista controleFutebolista;
    private Futebolista umFutebolista;
    private boolean modoAlteracao;
    private boolean novoRegistro;
    private DefaultListModel telefonesListModel;
    private DefaultListModel premiacaoListModel;

    public CadastroFutebolista() {
        initComponents();
        this.habilitarDesabilitarCampos();
        this.controleFutebolista = new ControleFutebolista();
        this.telefonesListModel = new DefaultListModel();
        this.jListTelefones.setModel(telefonesListModel);
        this.premiacaoListModel = new DefaultListModel();
        this.jListPremiacoes.setModel(premiacaoListModel);
        this.jTableListaFutebolista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    private void limparCampos() {
        jTextFieldAltura.setText("0.0");
        jTextFieldBairro.setText(null);
        jTextFieldCategoriasIdade.setText(null);
        jTextFieldCep.setText(null);
        jTextFieldCidade.setText(null);
        jTextFieldComplemento.setText(null);
        jTextFieldCpf.setText(null);
        jTextFieldDataNascimento.setText(null);
        jTextFieldPosicao.setText(null);
        jComboBoxEstado.setSelectedIndex(0);
        jTextFieldLogradouro.setText(null);
        jTextFieldNome.setText(null);
        jTextFieldNomeMae.setText(null);
        jTextFieldNomePai.setText(null);
        jTextFieldNumero.setText("0");
        jTextFieldPais.setText(null);
        jTextFieldIdade.setText("0.0");
        jTextFieldRg.setText(null);
        jTextFieldGolsContra.setText("0");
        jTextFieldNumeroCamisa.setText("0");
        jTextFieldGolsPro.setText("0");
        jTextFieldTimeAtual.setText(null);
        jTextFieldQualidades.setText(null);
        jTextFieldTimesAnteriores.setText(null);
        telefonesListModel.clear();
        premiacaoListModel.clear();
        jComboBoxSexo.setSelectedIndex(0);
        jComboBox1.setSelectedIndex(0);
        jComboBoxPernaBoa.setSelectedIndex(0);
        //this.atualizarCategoriasIdade();
    }

    private void preencherCampos() {
        ArrayList<String> telefones;
        ArrayList<Premiacao> premiacoes;

        jTextFieldAltura.setText(Double.toString(umFutebolista.getAltura()));
        jTextFieldBairro.setText(umFutebolista.getEndereco().getBairro());
        jTextFieldCategoriasIdade.setText(Double.toString(umFutebolista.getIdade()));
        jTextFieldCep.setText(umFutebolista.getEndereco().getCep());
        jTextFieldCidade.setText(umFutebolista.getEndereco().getCidade());
        jTextFieldComplemento.setText(umFutebolista.getEndereco().getComplemento());
        jTextFieldCpf.setText(umFutebolista.getCpf());
        if (umFutebolista.getDataNascimento() == null) {
            jTextFieldDataNascimento.setText(null);
        } else {
            jTextFieldDataNascimento.setText(dateFormat.format(umFutebolista.getDataNascimento()));
        }
        jTextFieldPosicao.setText(umFutebolista.getPosicao());
        jComboBoxEstado.setSelectedItem(umFutebolista.getEndereco().getEstado());
        jTextFieldLogradouro.setText(umFutebolista.getEndereco().getLogradouro());
        jTextFieldNome.setText(umFutebolista.getNome());
        jTextFieldNomeMae.setText(umFutebolista.getNomeMae());
        jTextFieldNomePai.setText(umFutebolista.getNomePai());
        jTextFieldNumero.setText(umFutebolista.getEndereco().getNumero().toString());
        jTextFieldPais.setText(umFutebolista.getEndereco().getPais());
        jTextFieldIdade.setText(Double.toString(umFutebolista.getIdade()));
        jTextFieldRg.setText(umFutebolista.getRg());
        jTextFieldGolsContra.setText(Integer.toString(umFutebolista.getGolsContra()));
        jTextFieldNumeroCamisa.setText(Integer.toString(umFutebolista.getNumeroCamisa()));
        jTextFieldGolsPro.setText(Integer.toString(umFutebolista.getGolsPro()));
        jTextFieldTimeAtual.setText(umFutebolista.getTimeAtual());
        jTextFieldQualidades.setText(umFutebolista.getQualidades());
        jTextFieldTimesAnteriores.setText(umFutebolista.getTimesAnteriores());

        telefonesListModel.clear();
        telefones = umFutebolista.getTelefones();
        for (String t : telefones) {
            telefonesListModel.addElement(t);
        }

        premiacaoListModel.clear();
        premiacoes = umFutebolista.getPremiacoes();
        for (Premiacao p : premiacoes) {
            premiacaoListModel.addElement(p);
        }

        switch (umFutebolista.getSexo()) {
            case SEXO_MASCULINO_VALOR:
                jComboBoxSexo.setSelectedIndex(SEXO_MASCULINO_INDICE);
                break;
            case SEXO_FEMININO_VALOR:
                jComboBoxSexo.setSelectedIndex(SEXO_FEMININO_INDICE);
                break;
        }

        switch (umFutebolista.getCategorias()) {
            case CATEGORIA_AMADOR_VALOR:
                jComboBox1.setSelectedIndex(CATEGORIA_AMADOR_INDICE);
                break;
            case CATEGORIA_PROFISSIONAL_VALOR:
                jComboBox1.setSelectedIndex(CATEGORIA_PROFISSIONAL_INDICE);
                break;
        }

        switch (umFutebolista.getPernaBoa()) {
            case PERNABOA_DESTRO_VALOR:
                jComboBoxPernaBoa.setSelectedIndex(PERNABOA_DESTRO_INDICE);
                break;
            case PERNABOA_CANHOTO_VALOR:
                jComboBoxPernaBoa.setSelectedIndex(PERNABOA_CANHOTO_INDICE);
                break;
        }

        this.atualizarCategoriasIdade();
    }

    private boolean validarCampos() {
        if (jTextFieldNome.getText().trim().length() == 0) {
            this.exibirInformacao("O valor do campo 'Nome' não foi informado.");
            jTextFieldNome.requestFocus();
            return false;
        }
        if (jTextFieldDataNascimento.getText().length() != 0) {
            try {
                dateFormat.parse(jTextFieldDataNascimento.getText());
            } catch (ParseException ex) {
                this.exibirInformacao("O valor do campo 'Data de Nascimento' é inválido.");
                jTextFieldDataNascimento.requestFocus();
                return false;
            }
        }
        try {
            Double.parseDouble(jTextFieldAltura.getText());
        } catch (Exception ex) {
            this.exibirInformacao("O valor do campo 'Altura' é inválido.");
            jTextFieldAltura.requestFocus();
            return false;
        }
        try {
            Double.parseDouble(jTextFieldIdade.getText());
        } catch (Exception ex) {
            this.exibirInformacao("O valor do campo 'Idade' é inválido.");
            jTextFieldIdade.requestFocus();
            return false;
        }
        if (!jTextFieldNumero.getText().equals("")) {
            try {
                Integer.parseInt(jTextFieldNumero.getText());
            } catch (Exception ex) {
                this.exibirInformacao("O valor do campo 'Número' é inválido.");
                jTextFieldNumero.requestFocus();
                return false;
            }
        }
        if(jTextFieldPosicao.getText().trim().length() == 0) {
            this.exibirInformacao("O valor do campo 'Posicao' não foi informado.");
            jTextFieldPosicao.requestFocus();
            return false;
        }
        try {
            Integer.parseInt(jTextFieldGolsContra.getText());
        } catch (Exception ex) {
            this.exibirInformacao("O valor do campo 'Gols Contra' é inválido.");
            jTextFieldGolsContra.requestFocus();
            return false;
        }
        try {
            Integer.parseInt(jTextFieldNumeroCamisa.getText());
        } catch (Exception ex) {
            this.exibirInformacao("O valor do campo 'Número da Camisa' é inválido.");
            jTextFieldNumeroCamisa.requestFocus();
            return false;
        }
        try {
            Integer.parseInt(jTextFieldGolsPro.getText());
        } catch (Exception ex) {
            this.exibirInformacao("O valor do campo 'Gols Pró' é inválido.");
            jTextFieldGolsPro.requestFocus();
            return false;
        }
        if(jTextFieldTimeAtual.getText().trim().length() == 0) {
            this.exibirInformacao("O valor do campo 'Time Atual' não foi informado.");
            jTextFieldTimeAtual.requestFocus();
            return false;
        }
        if(jTextFieldQualidades.getText().trim().length() == 0) {
            this.exibirInformacao("O valor do campo 'Qualidades' não foi informado.");
            jTextFieldQualidades.requestFocus();
            return false;
        }
        if(jTextFieldTimesAnteriores.getText().trim().length() == 0) {
            this.exibirInformacao("O valor do campo 'Times Anteriores' não foi informado.");
            jTextFieldTimesAnteriores.requestFocus();
            return false;
        }
        return true;
    }

    private void habilitarDesabilitarCampos() {
        boolean registroSelecionado = (umFutebolista != null);
        jTextFieldAltura.setEnabled(modoAlteracao);
        jTextFieldBairro.setEnabled(modoAlteracao);
        jTextFieldCategoriasIdade.setEnabled(false);
        jTextFieldCep.setEnabled(modoAlteracao);
        jTextFieldCidade.setEnabled(modoAlteracao);
        jTextFieldComplemento.setEnabled(modoAlteracao);
        jTextFieldCpf.setEnabled(modoAlteracao);
        jTextFieldDataNascimento.setEnabled(modoAlteracao);
        jTextFieldPosicao.setEnabled(modoAlteracao);
        jComboBoxEstado.setEnabled(modoAlteracao);
        jTextFieldLogradouro.setEnabled(modoAlteracao);
        jTextFieldNome.setEnabled(modoAlteracao);
        jTextFieldNomeMae.setEnabled(modoAlteracao);
        jTextFieldNomePai.setEnabled(modoAlteracao);
        jTextFieldNumero.setEnabled(modoAlteracao);
        jTextFieldPais.setEnabled(modoAlteracao);
        jTextFieldIdade.setEnabled(modoAlteracao);
        jTextFieldRg.setEnabled(modoAlteracao);
        jTextFieldGolsContra.setEnabled(modoAlteracao);
        jTextFieldNumeroCamisa.setEnabled(modoAlteracao);
        jTextFieldGolsPro.setEnabled(modoAlteracao);
        jTextFieldTimeAtual.setEnabled(modoAlteracao);
        jTextFieldQualidades.setEnabled(modoAlteracao);
        jTextFieldTimesAnteriores.setEnabled(modoAlteracao);
        jButtonNovo.setEnabled(modoAlteracao == false);
        jButtonAlterar.setEnabled(modoAlteracao == false && registroSelecionado == true);
        jButtonExcluir.setEnabled(modoAlteracao == false && registroSelecionado == true);
        jButtonPesquisar.setEnabled(modoAlteracao == false);
        jButtonSalvar.setEnabled(modoAlteracao);
        jButtonCancelar.setEnabled(modoAlteracao);
        jButtonAdicionarTelefone.setEnabled(modoAlteracao);
        jButtonRemoverTelefone.setEnabled(modoAlteracao);
        jButtonAdicionarPremiacao.setEnabled(modoAlteracao);
        jButtonRemoverPremiacao.setEnabled(modoAlteracao);
        jComboBoxSexo.setEnabled(modoAlteracao);
        jComboBox1.setEnabled(modoAlteracao);
        jComboBoxPernaBoa.setEnabled(modoAlteracao);
        jTableListaFutebolista.setEnabled(modoAlteracao == false);
    }

    private void salvarRegistro() {
        Endereco endereco;
        ArrayList<String> telefones;
        ArrayList<Premiacao> premiacoes;
        Date dataNascimento;

        if (this.validarCampos() == false) {
            return;
        }

        if (jTextFieldDataNascimento.getText().length() == 0) {
            dataNascimento = null;
        } else {
            try {
                dataNascimento = dateFormat.parse(jTextFieldDataNascimento.getText());
            } catch (ParseException ex) {
                exibirInformacao("Falha ao gravar a data de nascimento: " + ex.toString());
                return;
            }
        }

        endereco = new Endereco();
        endereco.setBairro(jTextFieldBairro.getText());
        endereco.setCep(jTextFieldCep.getText());
        endereco.setCidade(jTextFieldCidade.getText());
        endereco.setComplemento(jTextFieldComplemento.getText());
        endereco.setEstado((String) jComboBoxEstado.getSelectedItem());
        endereco.setLogradouro(jTextFieldLogradouro.getText());
        endereco.setNumero(jTextFieldNumero.getText());
        endereco.setPais(jTextFieldPais.getText());

        telefones = new ArrayList<String>();
        for (int i = 0; i < telefonesListModel.size(); i++) {
            telefones.add(telefonesListModel.getElementAt(i).toString());
        }

        premiacoes = new ArrayList<Premiacao>();
        for (int i = 0; i < premiacaoListModel.size(); i++) {
            Premiacao premiacao = (Premiacao) premiacaoListModel.getElementAt(i);
            premiacoes.add(premiacao);
        }

        if (novoRegistro == true) {
            umFutebolista = new Futebolista(jTextFieldNome.getText());
        } else {
            umFutebolista.setNome(jTextFieldNome.getText());
        }
        umFutebolista.setEndereco(endereco);
        umFutebolista.setTelefones(telefones);
        umFutebolista.setPremiacoes(premiacoes);
        umFutebolista.setDataNascimento(dataNascimento);
        umFutebolista.setAltura(Double.parseDouble(jTextFieldAltura.getText()));
        umFutebolista.setNomeMae(jTextFieldNomeMae.getText());
        umFutebolista.setNomePai(jTextFieldNomePai.getText());
        umFutebolista.setIdade(Integer.parseInt(jTextFieldIdade.getText()));
        umFutebolista.setCpf(jTextFieldCpf.getText());
        umFutebolista.setRg(jTextFieldRg.getText());
        umFutebolista.setPosicao(jTextFieldPosicao.getText());
        umFutebolista.setGolsContra(Integer.parseInt(jTextFieldGolsContra.getText()));
        umFutebolista.setNumeroCamisa(Integer.parseInt(jTextFieldNumeroCamisa.getText()));
        umFutebolista.setGolsPro(Integer.parseInt(jTextFieldGolsPro.getText()));
        umFutebolista.setTimeAtual(jTextFieldTimeAtual.getText());
        umFutebolista.setQualidades(jTextFieldQualidades.getText());
        umFutebolista.setTimesAnteriores(jTextFieldTimesAnteriores.getText());

        switch (jComboBoxSexo.getSelectedIndex()) {
            case SEXO_MASCULINO_INDICE:
                umFutebolista.setSexo(SEXO_MASCULINO_VALOR);
                break;
            case SEXO_FEMININO_INDICE:
                umFutebolista.setSexo(SEXO_FEMININO_VALOR);
                break;
        }

        switch (jComboBox1.getSelectedIndex()) {
            case CATEGORIA_AMADOR_INDICE:
                umFutebolista.setCategorias(CATEGORIA_AMADOR_VALOR);
                break;
            case CATEGORIA_PROFISSIONAL_INDICE:
                umFutebolista.setCategorias(CATEGORIA_PROFISSIONAL_VALOR);
                break;
        }

        switch (jComboBoxPernaBoa.getSelectedIndex()) {
            case PERNABOA_DESTRO_INDICE:
                umFutebolista.setPernaBoa(PERNABOA_DESTRO_VALOR);
                break;
            case PERNABOA_CANHOTO_INDICE:
                umFutebolista.setPernaBoa(PERNABOA_CANHOTO_VALOR);
                break;
        }

        if (novoRegistro == true) {
            controleFutebolista.adicionar(umFutebolista);
        }
        modoAlteracao = false;
        novoRegistro = false;
        this.carregarListaFutebolista();
        this.habilitarDesabilitarCampos();
    }

    private void carregarListaFutebolista() {
        ArrayList<Futebolista> listaFutebolista = controleFutebolista.getListaFutebolista();
        DefaultTableModel model = (DefaultTableModel) jTableListaFutebolista.getModel();
        model.setRowCount(0);
        for (Futebolista umNome : listaFutebolista) {
            model.addRow(new String[]{umNome.getNome(), umNome.getCpf()});
        }
        jTableListaFutebolista.setModel(model);
    }

    private void exibirInformacao(String info) {
        JOptionPane.showMessageDialog(this, info, "Atenção", JOptionPane.INFORMATION_MESSAGE);
    }

    private void atualizarCategoriasIdade() {
        char categorias;
        switch (jComboBox1.getSelectedIndex()) {
            case CATEGORIA_AMADOR_INDICE:
                categorias = CATEGORIA_AMADOR_VALOR;
                break;
            case CATEGORIA_PROFISSIONAL_INDICE:
                categorias = CATEGORIA_PROFISSIONAL_VALOR;
                break;
            default:
                return;
        }
        jTextFieldCategoriasIdade.setText(Futebolista.obterCategoriasIdade(categorias, Integer.parseInt(jTextFieldIdade.getText())));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButtonNovo = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jTextFieldNome = new javax.swing.JTextField();
        jLabelNome = new javax.swing.JLabel();
        jLabelDataNascimento = new javax.swing.JLabel();
        jLabelAltura = new javax.swing.JLabel();
        jTextFieldAltura = new javax.swing.JTextField();
        jTextFieldIdade = new javax.swing.JTextField();
        jLabelPeso = new javax.swing.JLabel();
        jTextFieldNomePai = new javax.swing.JTextField();
        jLabelNomePai = new javax.swing.JLabel();
        jTextFieldNomeMae = new javax.swing.JTextField();
        jLabelNomeMae = new javax.swing.JLabel();
        jLabelSexo = new javax.swing.JLabel();
        jLabelRg = new javax.swing.JLabel();
        jLabelCpf = new javax.swing.JLabel();
        jLabelTelefones = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListTelefones = new javax.swing.JList();
        jButtonAdicionarTelefone = new javax.swing.JButton();
        jButtonRemoverTelefone = new javax.swing.JButton();
        jComboBoxSexo = new javax.swing.JComboBox();
        jTextFieldDataNascimento = new javax.swing.JTextField();
        jTextFieldRg = new javax.swing.JTextField();
        jTextFieldCpf = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabelLogradouro = new javax.swing.JLabel();
        jTextFieldLogradouro = new javax.swing.JTextField();
        jLabelNumero = new javax.swing.JLabel();
        jTextFieldNumero = new javax.swing.JTextField();
        jTextFieldBairro = new javax.swing.JTextField();
        jLabelBairro = new javax.swing.JLabel();
        jTextFieldCidade = new javax.swing.JTextField();
        jLabelCidade = new javax.swing.JLabel();
        jLabelEstado = new javax.swing.JLabel();
        jLabelPais = new javax.swing.JLabel();
        jTextFieldPais = new javax.swing.JTextField();
        jLabelComplemento = new javax.swing.JLabel();
        jTextFieldComplemento = new javax.swing.JTextField();
        jLabelCep = new javax.swing.JLabel();
        jComboBoxEstado = new javax.swing.JComboBox();
        jTextFieldCep = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabelCategorias = new javax.swing.JLabel();
        jLabelCategoriasIdade = new javax.swing.JLabel();
        jLabelPernaBoa = new javax.swing.JLabel();
        jComboBoxPernaBoa = new javax.swing.JComboBox();
        jTextFieldPosicao = new javax.swing.JTextField();
        jLabelPosicao = new javax.swing.JLabel();
        jLabelTotalLutas = new javax.swing.JLabel();
        jTextFieldTimeAtual = new javax.swing.JTextField();
        jTextFieldTimesAnteriores = new javax.swing.JTextField();
        jLabelTotalVitorias = new javax.swing.JLabel();
        jTextFieldQualidades = new javax.swing.JTextField();
        jLabelTotalVitoriasNocaute = new javax.swing.JLabel();
        jTextFieldGolsPro = new javax.swing.JTextField();
        jLabelTotalEmpates = new javax.swing.JLabel();
        jLabelTotalDerrotas = new javax.swing.JLabel();
        jTextFieldGolsContra = new javax.swing.JTextField();
        jLabelTotalDesistencias = new javax.swing.JLabel();
        jTextFieldNumeroCamisa = new javax.swing.JTextField();
        jTextFieldCategoriasIdade = new javax.swing.JTextField();
        jLabelPremiacoes = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListPremiacoes = new javax.swing.JList();
        jButtonAdicionarPremiacao = new javax.swing.JButton();
        jButtonRemoverPremiacao = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        jButtonAlterar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jButtonSalvar = new javax.swing.JButton();
        jButtonPesquisar = new javax.swing.JButton();
        jLabelListaBoxeadores = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableListaFutebolista = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonNovo.setText("Novo");
        jButtonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoActionPerformed(evt);
            }
        });

        jLabelNome.setText("Nome:");

        jLabelDataNascimento.setText("Data de Nascimento:");

        jLabelAltura.setText("Altura:");

        jTextFieldIdade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIdadeActionPerformed(evt);
            }
        });
        jTextFieldIdade.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldIdadeFocusLost(evt);
            }
        });
        jTextFieldIdade.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTextFieldIdadePropertyChange(evt);
            }
        });

        jLabelPeso.setText("Idade:");

        jLabelNomePai.setText("Nome do Pai:");

        jLabelNomeMae.setText("Nome da Mãe:");

        jLabelSexo.setText("Sexo:");

        jLabelRg.setText("RG:");

        jLabelCpf.setText("CPF:");

        jLabelTelefones.setText("Telefones:");

        jListTelefones.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jListTelefones);

        jButtonAdicionarTelefone.setText("+");
        jButtonAdicionarTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarTelefoneActionPerformed(evt);
            }
        });

        jButtonRemoverTelefone.setText("-");
        jButtonRemoverTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoverTelefoneActionPerformed(evt);
            }
        });

        jComboBoxSexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Masculino", "Feminino" }));

        jTextFieldDataNascimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDataNascimentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelTelefones, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelRg, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNomePai, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNomeMae, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelDataNascimento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelSexo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextFieldDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelAltura)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldAltura, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelPeso)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldIdade, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonAdicionarTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonRemoverTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jComboBoxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldNomeMae, javax.swing.GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE)
                    .addComponent(jTextFieldNomePai, javax.swing.GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jTextFieldCpf, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextFieldRg, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabelNomePai, jLabelSexo});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNome)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelDataNascimento)
                            .addComponent(jTextFieldDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelSexo)
                            .addComponent(jComboBoxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelPeso))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldAltura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelAltura)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNomePai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNomePai))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNomeMae, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNomeMae))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelRg)
                    .addComponent(jTextFieldRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCpf)
                    .addComponent(jTextFieldCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTelefones)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonAdicionarTelefone)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonRemoverTelefone))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(94, 94, 94))
        );

        jTabbedPane1.addTab("Informações Gerais", jPanel1);

        jLabelLogradouro.setText("Logradouro:");

        jLabelNumero.setText("Número:");

        jLabelBairro.setText("Bairro:");

        jLabelCidade.setText("Cidade:");

        jLabelEstado.setText("Estado:");

        jLabelPais.setText("País:");

        jLabelComplemento.setText("Complemento:");

        jLabelCep.setText("CEP:");

        jComboBoxEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelComplemento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelPais, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                    .addComponent(jLabelCidade, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                    .addComponent(jLabelBairro, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                    .addComponent(jLabelNumero, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                    .addComponent(jLabelCep, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                    .addComponent(jLabelEstado, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                    .addComponent(jLabelLogradouro, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldComplemento, javax.swing.GroupLayout.DEFAULT_SIZE, 644, Short.MAX_VALUE)
                    .addComponent(jTextFieldNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldLogradouro, javax.swing.GroupLayout.DEFAULT_SIZE, 644, Short.MAX_VALUE)
                    .addComponent(jComboBoxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jTextFieldCep, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextFieldPais, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTextFieldLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabelLogradouro)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNumero)
                    .addComponent(jTextFieldNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelComplemento)
                    .addComponent(jTextFieldComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelBairro)
                    .addComponent(jTextFieldBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCidade)
                    .addComponent(jTextFieldCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelEstado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPais)
                    .addComponent(jTextFieldPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCep)
                    .addComponent(jTextFieldCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(133, 133, 133))
        );

        jTabbedPane1.addTab("Endereço", jPanel2);

        jLabelCategorias.setText("Categorias:");

        jLabelCategoriasIdade.setText("Categorias (Idade):");

        jLabelPernaBoa.setText("Perna Boa:");

        jComboBoxPernaBoa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Destro", "Canhoto" }));
        jComboBoxPernaBoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxPernaBoaActionPerformed(evt);
            }
        });

        jLabelPosicao.setText("Posição");

        jLabelTotalLutas.setText("Time Atual");

        jLabelTotalVitorias.setText("Times Anteriores");

        jLabelTotalVitoriasNocaute.setText("Qualidades");

        jLabelTotalEmpates.setText("Gols Pró");

        jLabelTotalDerrotas.setText("Gols Contra");

        jLabelTotalDesistencias.setText("Número da Camisa");

        jTextFieldCategoriasIdade.setEnabled(false);

        jLabelPremiacoes.setText("Premiações:");

        jScrollPane2.setViewportView(jListPremiacoes);

        jButtonAdicionarPremiacao.setText("+");
        jButtonAdicionarPremiacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarPremiacaoActionPerformed(evt);
            }
        });

        jButtonRemoverPremiacao.setText("-");
        jButtonRemoverPremiacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoverPremiacaoActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Amador", "Profissional" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelPosicao)
                    .addComponent(jLabelCategorias)
                    .addComponent(jLabelCategoriasIdade)
                    .addComponent(jLabelPernaBoa)
                    .addComponent(jLabelTotalLutas)
                    .addComponent(jLabelTotalVitorias)
                    .addComponent(jLabelTotalVitoriasNocaute)
                    .addComponent(jLabelTotalEmpates)
                    .addComponent(jLabelTotalDerrotas)
                    .addComponent(jLabelTotalDesistencias))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox1, 0, 299, Short.MAX_VALUE)
                    .addComponent(jTextFieldNumeroCamisa, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                    .addComponent(jTextFieldGolsContra, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                    .addComponent(jTextFieldGolsPro, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                    .addComponent(jTextFieldQualidades, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                    .addComponent(jTextFieldTimesAnteriores, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                    .addComponent(jTextFieldTimeAtual, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                    .addComponent(jTextFieldPosicao, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                    .addComponent(jComboBoxPernaBoa, 0, 299, Short.MAX_VALUE)
                    .addComponent(jTextFieldCategoriasIdade, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelPremiacoes)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButtonRemoverPremiacao, javax.swing.GroupLayout.Alignment.LEADING, 0, 0, Short.MAX_VALUE)
                            .addComponent(jButtonAdicionarPremiacao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelCategorias)
                            .addComponent(jLabelPremiacoes)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelCategoriasIdade)
                            .addComponent(jTextFieldCategoriasIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxPernaBoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelPernaBoa))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelPosicao)
                            .addComponent(jTextFieldPosicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelTotalLutas)
                            .addComponent(jTextFieldTimeAtual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelTotalVitorias)
                            .addComponent(jTextFieldTimesAnteriores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelTotalVitoriasNocaute)
                            .addComponent(jTextFieldQualidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelTotalEmpates)
                            .addComponent(jTextFieldGolsPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelTotalDerrotas)
                            .addComponent(jTextFieldGolsContra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelTotalDesistencias)
                            .addComponent(jTextFieldNumeroCamisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jButtonAdicionarPremiacao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonRemoverPremiacao))
                            .addComponent(jScrollPane2))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Ficha Técnica", jPanel3);

        jButtonAlterar.setText("Alterar");
        jButtonAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterarActionPerformed(evt);
            }
        });

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jButtonExcluir.setText("Excluir");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jButtonPesquisar.setText("Pesquisar...");
        jButtonPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarActionPerformed(evt);
            }
        });

        jLabelListaBoxeadores.setText("Lista de Futebolistas:");

        jTableListaFutebolista.setModel(new javax.swing.table.DefaultTableModel 
            (
                null,
                new String [] {
                    "Nome", "CPF"
                }
            )
            {
                @Override    
                public boolean isCellEditable(int rowIndex, int mColIndex) {
                    return false;
                }
            });
            jTableListaFutebolista.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    jTableListaFutebolistaMouseClicked(evt);
                }
            });
            jScrollPane4.setViewportView(jTableListaFutebolista);

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabelListaBoxeadores)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jButtonNovo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButtonAlterar)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButtonExcluir)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButtonPesquisar)
                            .addGap(222, 222, 222)
                            .addComponent(jButtonSalvar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 761, Short.MAX_VALUE))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );

            layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButtonAlterar, jButtonCancelar, jButtonExcluir, jButtonNovo, jButtonPesquisar, jButtonSalvar});

            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonNovo)
                        .addComponent(jButtonAlterar)
                        .addComponent(jButtonExcluir)
                        .addComponent(jButtonPesquisar)
                        .addComponent(jButtonSalvar)
                        .addComponent(jButtonCancelar))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabelListaBoxeadores)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(41, Short.MAX_VALUE))
            );

            pack();
        }// </editor-fold>//GEN-END:initComponents

    private void jButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoActionPerformed
        umFutebolista = null;
        modoAlteracao = true;
        novoRegistro = true;
        this.limparCampos();
        this.habilitarDesabilitarCampos();
        this.jTextFieldNome.requestFocus();
    }//GEN-LAST:event_jButtonNovoActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        this.salvarRegistro();
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        if (novoRegistro == true) {
            this.limparCampos();
        } else {
            this.preencherCampos();
        }
        modoAlteracao = false;
        novoRegistro = false;
        this.habilitarDesabilitarCampos();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jTextFieldIdadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIdadeActionPerformed
    }//GEN-LAST:event_jTextFieldIdadeActionPerformed

    private void jTextFieldIdadePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTextFieldIdadePropertyChange
    }//GEN-LAST:event_jTextFieldIdadePropertyChange

    private void jTextFieldIdadeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldIdadeFocusLost
        this.atualizarCategoriasIdade();
    }//GEN-LAST:event_jTextFieldIdadeFocusLost

    private void jButtonAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarActionPerformed
        modoAlteracao = true;
        novoRegistro = false;
        this.habilitarDesabilitarCampos();
        this.jTextFieldNome.requestFocus();
    }//GEN-LAST:event_jButtonAlterarActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        this.controleFutebolista.remover(umFutebolista);
        umFutebolista = null;
        this.limparCampos();
        this.carregarListaFutebolista();
        this.habilitarDesabilitarCampos();
    }//GEN-LAST:event_jButtonExcluirActionPerformed

private void jButtonAdicionarTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarTelefoneActionPerformed
    CadastroTelefone cadastro = new CadastroTelefone(this, true);
    cadastro.setVisible(true);
    if (cadastro.getTelefone() != null) {
        telefonesListModel.addElement(cadastro.getTelefone());
    }
    cadastro.dispose();
}//GEN-LAST:event_jButtonAdicionarTelefoneActionPerformed

private void jButtonRemoverTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoverTelefoneActionPerformed
    if (jListTelefones.getSelectedIndex() != -1) {
        telefonesListModel.removeElementAt(jListTelefones.getSelectedIndex());
    }
}//GEN-LAST:event_jButtonRemoverTelefoneActionPerformed

private void jButtonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarActionPerformed
    String pesquisa = JOptionPane.showInputDialog("Informe o nome do Futebolista.");
    if (pesquisa != null) {
        this.pesquisarFutebolista(pesquisa);
    }
}//GEN-LAST:event_jButtonPesquisarActionPerformed

    private void pesquisarFutebolista(String nome) {
        Futebolista futebolistaPesquisado = controleFutebolista.pesquisar(nome);

        if (futebolistaPesquisado == null) {
            exibirInformacao("Futebolista não encontrado.");
        } else {
            this.umFutebolista = futebolistaPesquisado;
            this.preencherCampos();
            this.habilitarDesabilitarCampos();
        }
    }

private void jButtonAdicionarPremiacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarPremiacaoActionPerformed
    CadastroPremiacao cadastro = new CadastroPremiacao(this, true);
    cadastro.setVisible(true);
    if (cadastro.getPremiacao() != null) {
        premiacaoListModel.addElement(cadastro.getPremiacao());
    }
    cadastro.dispose();
}//GEN-LAST:event_jButtonAdicionarPremiacaoActionPerformed

private void jButtonRemoverPremiacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoverPremiacaoActionPerformed
    if (jListPremiacoes.getSelectedIndex() != -1) {
        premiacaoListModel.removeElementAt(jListPremiacoes.getSelectedIndex());
    }
}//GEN-LAST:event_jButtonRemoverPremiacaoActionPerformed

private void jTableListaFutebolistaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableListaFutebolistaMouseClicked
    if (jTableListaFutebolista.isEnabled()) {
        DefaultTableModel model = (DefaultTableModel) jTableListaFutebolista.getModel();
        String nome = (String) model.getValueAt(jTableListaFutebolista.getSelectedRow(), 0);
        this.pesquisarFutebolista(nome);
    }
}//GEN-LAST:event_jTableListaFutebolistaMouseClicked

private void jTextFieldDataNascimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDataNascimentoActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_jTextFieldDataNascimentoActionPerformed

private void jComboBoxPernaBoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxPernaBoaActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_jComboBoxPernaBoaActionPerformed

private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_jComboBox1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdicionarPremiacao;
    private javax.swing.JButton jButtonAdicionarTelefone;
    private javax.swing.JButton jButtonAlterar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonNovo;
    private javax.swing.JButton jButtonPesquisar;
    private javax.swing.JButton jButtonRemoverPremiacao;
    private javax.swing.JButton jButtonRemoverTelefone;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBoxEstado;
    private javax.swing.JComboBox jComboBoxPernaBoa;
    private javax.swing.JComboBox jComboBoxSexo;
    private javax.swing.JLabel jLabelAltura;
    private javax.swing.JLabel jLabelBairro;
    private javax.swing.JLabel jLabelCategorias;
    private javax.swing.JLabel jLabelCategoriasIdade;
    private javax.swing.JLabel jLabelCep;
    private javax.swing.JLabel jLabelCidade;
    private javax.swing.JLabel jLabelComplemento;
    private javax.swing.JLabel jLabelCpf;
    private javax.swing.JLabel jLabelDataNascimento;
    private javax.swing.JLabel jLabelEstado;
    private javax.swing.JLabel jLabelListaBoxeadores;
    private javax.swing.JLabel jLabelLogradouro;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelNomeMae;
    private javax.swing.JLabel jLabelNomePai;
    private javax.swing.JLabel jLabelNumero;
    private javax.swing.JLabel jLabelPais;
    private javax.swing.JLabel jLabelPernaBoa;
    private javax.swing.JLabel jLabelPeso;
    private javax.swing.JLabel jLabelPosicao;
    private javax.swing.JLabel jLabelPremiacoes;
    private javax.swing.JLabel jLabelRg;
    private javax.swing.JLabel jLabelSexo;
    private javax.swing.JLabel jLabelTelefones;
    private javax.swing.JLabel jLabelTotalDerrotas;
    private javax.swing.JLabel jLabelTotalDesistencias;
    private javax.swing.JLabel jLabelTotalEmpates;
    private javax.swing.JLabel jLabelTotalLutas;
    private javax.swing.JLabel jLabelTotalVitorias;
    private javax.swing.JLabel jLabelTotalVitoriasNocaute;
    private javax.swing.JList jListPremiacoes;
    private javax.swing.JList jListTelefones;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTableListaFutebolista;
    private javax.swing.JTextField jTextFieldAltura;
    private javax.swing.JTextField jTextFieldBairro;
    private javax.swing.JTextField jTextFieldCategoriasIdade;
    private javax.swing.JTextField jTextFieldCep;
    private javax.swing.JTextField jTextFieldCidade;
    private javax.swing.JTextField jTextFieldComplemento;
    private javax.swing.JTextField jTextFieldCpf;
    private javax.swing.JTextField jTextFieldDataNascimento;
    private javax.swing.JTextField jTextFieldGolsContra;
    private javax.swing.JTextField jTextFieldGolsPro;
    private javax.swing.JTextField jTextFieldIdade;
    private javax.swing.JTextField jTextFieldLogradouro;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldNomeMae;
    private javax.swing.JTextField jTextFieldNomePai;
    private javax.swing.JTextField jTextFieldNumero;
    private javax.swing.JTextField jTextFieldNumeroCamisa;
    private javax.swing.JTextField jTextFieldPais;
    private javax.swing.JTextField jTextFieldPosicao;
    private javax.swing.JTextField jTextFieldQualidades;
    private javax.swing.JTextField jTextFieldRg;
    private javax.swing.JTextField jTextFieldTimeAtual;
    private javax.swing.JTextField jTextFieldTimesAnteriores;
    // End of variables declaration//GEN-END:variables
}
