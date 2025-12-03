/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package main_package;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author user
 */
public class AddressDialog extends javax.swing.JDialog {

    /**
     * Creates new form AddressDialog
     */
    DatabaseManager dbManager = new DatabaseManager();
    private CheckoutFrame checkout;

    public AddressDialog(java.awt.Frame parent, boolean modal, CheckoutFrame checkout) {
        super(parent, modal);
        initComponents();
        this.checkout = checkout;

        setLocationRelativeTo(null);
        loadBarangayData();
    }

    Map<String, String[]> barangayData = new HashMap<>();

    private void loadBarangayData() {
        barangayData.put("Angat", new String[]{
            "Banaban", "Baybay", "Binagbag", "Donacion", "Encanto",
            "Laog", "Marungko", "Niugan", "Paltok", "Pulong Yantok",
            "San Roque", "Santa Cruz", "Santa Lucia", "Santo Cristo", "Sulucan",
            "Taboc"
        });

        barangayData.put("Balagtas", new String[]{
            "Borol 1st", "Borol 2nd", "Dalig", "Longos", "Panginay",
            "Pulong Gubat", "San Juan", "Santol", "Wawa"
        });

        barangayData.put("Baliwag", new String[]{
            "Bagong Nayon", "Barangca", "Calantipay", "Catulinan", "Concepcion",
            "Hinukay", "Makinabang", "Matangtubig", "Pagala", "Paitan",
            "Piel", "Pinagbarilan", "Poblacion", "Sabang", "San Jose",
            "San Roque", "Santa Barbara", "Santo Cristo", "Santo Niño", "Subic",
            "Sulivan", "Tangos", "Tarcan", "Tiaong", "Tibag", "Tilapayong", "Virgen delas Flores"
        });

        barangayData.put("Bocaue", new String[]{
            "Antipona", "Bagumbayan", "Bambang", "Batia", "Biñang 1st",
            "Biñang 2nd", "Bolacan", "Bundukan", "Bunlo", "Caingin",
            "Duhat", "Igulot", "Lolomboy", "Poblacion", "Sulucan",
            "Taal", "Tambobong", "Turo", "Wakas"
        });

        barangayData.put("Bulakan", new String[]{
            "Bagumbayan", "Balubad", "Bambang", "Matungao", "Maysantol",
            "Perez", "Pitpitan", "San Francisco", "San Jose", "San Nicolas",
            "Santa Ana", "Santa Ines", "Taliptip", "Tibig"
        });

        barangayData.put("Bustos", new String[]{
            "Bonga Mayor", "Bonga Menor", "Buisan", "Camachilihan", "Cambaog",
            "Catacte", "Liciada", "Malamig", "Malawak", "Poblacion",
            "San Pedro", "Talampas", "Tanawan", "Tibagan"
        });

        barangayData.put("Calumpit", new String[]{
            "Balite", "Balungao", "Buguion", "Bulusan", "Calizon",
            "Calumpang", "Caniogan", "Corazon", "Frances", "Gatbuca",
            "Gugo", "Iba Este", "Iba O’Este", "Longos", "Meysulao",
            "Meyto", "Palimbang", "Panducot", "Pio Cruzcosa", "Poblacion",
            "Pungo", "San Jose", "San Marcos", "San Miguel", "Santa Lucia",
            "Santo Niño", "Sapang Bayan", "Sergio Bayan", "Sucol"
        });

        barangayData.put("Doña Remedios Trinidad", new String[]{
            "Bayabas", "Camachile", "Camachin", "Kabayunan",
            "Kalawakan", "Pulong Sampalok", "Sapang Bulak", "Talbak"
        });

        // Hagonoy
        barangayData.put("Hagonoy", new String[]{
            "Abulalas", "Carillo", "Iba", "Iba‑Ibayo", "Mercado",
            "Palapat", "Pugad", "Sagrada Familia", "San Agustin", "San Isidro",
            "San Jose", "San Juan", "San Miguel", "San Nicolas", "San Pablo",
            "San Pascual", "San Pedro", "San Roque", "San Sebastian", "Santa Cruz",
            "Santa Elena", "Santa Monica", "Santo Niño", "Santo Rosario", "Tampok",
            "Tibaguin"
        });

// Marilao
        barangayData.put("Marilao", new String[]{
            "Abangan Norte", "Abangan Sur", "Ibayo", "Lambakin", "Lias",
            "Loma de Gato", "Nagbalon", "Patubig", "Poblacion 1st", "Poblacion 2nd",
            "Prenza 1st", "Prenza 2nd", "Santa Rosa 1st", "Santa Rosa 2nd", "Saog",
            "Tabing‑ilog"
        });

// Meycauayan
        barangayData.put("Meycauayan", new String[]{
            "Bagbaguin", "Bahay Pare", "Bancal", "Banga", "Bayugo",
            "Caingin", "Calvario", "Camalig", "Hulo", "Iba",
            "Langka", "Lawa", "Libtong", "Liputan", "Longos",
            "Malhacan", "Pajo", "Pandayan", "Pantoc", "Perez",
            "Poblacion", "Saint Francis", "Saluysoy", "Tugatog", "Ubihan",
            "Zamora"
        });

// Norzagaray
        barangayData.put("Norzagaray", new String[]{
            "Bangkal", "Baraka", "Bigte", "Bitungol", "Friendship Village Resources (FVR)",
            "Matictic", "Minuyan", "Partida", "Pinagtulayan", "Poblacion",
            "San Lorenzo", "San Mateo", "Tigbe"
        });

// Obando
        barangayData.put("Obando", new String[]{
            "Aplaya", "Binuangan", "Caingin", "Meyto", "Poblacion",
            "San Jose", "San Pascual", "Santa Rosa", "Tambobong"
        });

// Pandi
        barangayData.put("Pandi", new String[]{
            "Bagumbayan", "Banga", "Biga", "Camachile", "Dalig",
            "Iba", "Mabayo", "Maligaya", "San Isidro", "San Juan",
            "San Roque", "Santa Maria"
        });

// Paombong
        barangayData.put("Paombong", new String[]{
            "Bagong Silang", "Banaban", "Camachile", "Kaingin", "Poblacion",
            "San Juan", "San Nicolas", "Santa Isabel"
        });

// Plaridel
        barangayData.put("Plaridel", new String[]{
            "Agnaya", "Bagong Silang", "Banga I", "Banga II", "Bintog",
            "Bulihan", "Culianin", "Dampol", "Lagundi", "Lalangan",
            "Lumang Bayan", "Parulan", "Poblacion", "Rueda", "San Jose",
            "Santa Ines", "Santo Niño", "Sipat", "Tabang"
        });

// Pulilan
        barangayData.put("Pulilan", new String[]{
            "Balatong A", "Balatong B", "Cutcot", "Dampol I", "Dampol II‑A",
            "Dampol II‑B", "Dulong Malabon", "Inaon", "Longos", "Lumbac",
            "Paltao", "Penabatan", "Poblacion", "Santa Peregrina", "Santo Cristo",
            "Taal", "Tabon", "Tibag", "Tinejero"
        });

// San Ildefonso
        barangayData.put("San Ildefonso", new String[]{
            "Akle", "Alagao", "Anyatam", "Bagong Barrio", "Basuit",
            "Bubulong Malaki", "Bubulong Munti", "Buhol na Mangga", "Bulusukan", "Calasag",
            "Calawitan", "Casalat", "Gabihan", "Garlang", "Lapnit",
            "Maasim", "Makapilapil", "Malipampang", "Mataas na Parang", "Matimbubong",
            "Nabaong Garlang", "Palapala", "Pasong Bangkal", "Pinaod", "Poblacion",
            "Pulong Tamo", "San Juan", "Santa Catalina Bata", "Santa Catalina Matanda", "Sapang Dayap",
            "Sapang Putik", "Sapang Putol", "Sumandig", "Telapatio", "Umpucan", "Upig"
        });

// San Jose del Monte
        barangayData.put("San Jose del Monte", new String[]{
            "Bayanihan", "Camias", "Fatima", "Langgam", "Loma de Gato",
            "Poblacion", "San Isidro", "San Jose", "San Miguel", "Santa Cruz",
            "Santo Cristo", "Tungkong Mangga"
        });

// San Miguel
        barangayData.put("San Miguel", new String[]{
            "Bagong Pag‑asa", "Bagong Silang", "Balaong", "Balite", "Bantog",
            "Bardias", "Baritan", "Batasan Bata", "Batasan Matanda", "Biak‑na‑Bato",
            "Biclat", "Buga", "Buliran", "Bulualto", "Calumpang",
            "Cambio", "Camias", "Ilog‑Bulo", "King Kabayo", "Labne",
            "Lambakin", "Magmarale", "Malibay", "Maligaya", "Mandile",
            "Masalipit", "Pacalag", "Paliwasan", "Partida", "Pinambaran",
            "Poblacion", "Pulong Bayabas", "Pulong Duhat", "Sacdalan", "Salacot",
            "Salangan", "San Agustin", "San Jose", "San Juan", "San Vicente",
            "Santa Ines", "Santa Lucia", "Santa Rita Bata", "Santa Rita Matanda", "Sapang",
            "Sibul", "Tartaro", "Tibagan", "Tigpalas"
        });

// San Rafael
        barangayData.put("San Rafael", new String[]{
            "Banca‑banca", "BMA‑Balagtas", "Caingin", "Coral na Bato", "Cruz na Daan",
            "Dagat‑Dagatan", "Diliman I", "Diliman II", "Capihan", "Libis",
            "Lico", "Maasim", "Mabalas‑Balas", "Maguinao", "Maronquillo",
            "Paco", "Pansumaloc", "Pantubig", "Pasong Bangkal", "Pasong Callos",
            "Pasong Intsik", "Pinacpinacan", "Poblacion", "Pulo", "Pulong Bayabas",
            "Salapungan", "Sampaloc", "San Agustin", "San Roque", "Sapang Pahalang",
            "Talacsan", "Tambubong", "Tukod", "Ulingao"
        });

// Santa Maria
        barangayData.put("Santa Maria", new String[]{
            "Bagbaguin", "Balasing", "Banga", "Biga", "Bulac", "Camias",
            "Kaingin", "Poblacion", "San Isidro", "San Jose", "San Rafael",
            "Santa Clara", "Santa Cruz", "Santo Niño"
        });

        String[] municipalities = {
            "Angat", "Balagtas", "Baliwag", "Bocaue", "Bulakan", "Bustos", "Calumpit",
            "Doña Remedios Trinidad", "Guiguinto", "Hagonoy", "Marilao", "Meycauayan",
            "Norzagaray", "Obando", "Pandi", "Paombong", "Plaridel", "Pulilan",
            "San Ildefonso", "San Jose del Monte", "San Miguel", "San Rafael", "Santa Maria"
        };

        for (String m : municipalities) {
            cityField.addItem(m);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        streetField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        zipCodeField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        provinceField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        warningLabel = new javax.swing.JLabel();
        houseNumberField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        saveButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        cityField = new javax.swing.JComboBox<>();
        barangayField = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Street");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, -1));

        streetField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                streetFieldActionPerformed(evt);
            }
        });
        jPanel1.add(streetField, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 250, 38));

        jLabel3.setText("City / Municipality");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 70, -1, -1));

        jLabel4.setText("Zip Code");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 240, -1, -1));

        zipCodeField.setToolTipText("");
        jPanel1.add(zipCodeField, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 260, 250, 38));

        jLabel5.setText("Province");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        provinceField.setEditable(false);
        provinceField.setText("BULACAN");
        provinceField.setToolTipText("");
        jPanel1.add(provinceField, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 250, 38));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(48, 48, 48));
        jLabel6.setText("Enter your shipping address");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, -1, -1));

        warningLabel.setForeground(new java.awt.Color(255, 0, 0));
        warningLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(warningLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 330, 370, 20));

        houseNumberField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                houseNumberFieldActionPerformed(evt);
            }
        });
        jPanel1.add(houseNumberField, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 170, 250, 38));

        jLabel7.setText("House No.");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 150, -1, -1));

        saveButton.setBackground(new java.awt.Color(159, 133, 85));
        saveButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        saveButton.setForeground(new java.awt.Color(255, 255, 255));
        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });
        jPanel1.add(saveButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 370, 100, 40));

        cancelButton.setBackground(new java.awt.Color(159, 133, 85));
        cancelButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cancelButton.setForeground(new java.awt.Color(255, 255, 255));
        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        jPanel1.add(cancelButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 370, 100, 40));

        cityField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cityFieldActionPerformed(evt);
            }
        });
        jPanel1.add(cityField, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 90, 250, 40));

        jPanel1.add(barangayField, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 250, 40));

        jLabel8.setText("Barangay");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 70, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 460));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void streetFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_streetFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_streetFieldActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        //S, B, C, P, Z

         String street = streetField.getText().toString().trim();
        String barangay = barangayField.getSelectedItem().toString().trim();
        String city = cityField.getSelectedItem().toString().trim();
        String province = provinceField.getText().toString().trim();
        String zipCode = zipCodeField.getText().toString().trim();
        String houseNumber = houseNumberField.getText().toString().trim();

        String email = DashboardFrame.emailHolder.getText().toString().trim();

        if (street.isEmpty() || barangay.isEmpty() || city.isEmpty() || province.isEmpty() || zipCode.isEmpty()) {
            warningLabel.setText("Please fill out all the fields!");
        } else {
            warningLabel.setText("");
            String fullAddressContainer = "#" + houseNumber + " " + street + ", Brgy. " + barangay + ", " + city + ", " + province;
            DashboardFrame.addressReader.setText(fullAddressContainer);
            dbManager.updateAddress(street, barangay, city, province, zipCode, houseNumber, email);
            this.dispose();
            
            checkout.refreshAfterAddressUpdate(email); 
        }

        String selectedMunicipality = (String) cityField.getSelectedItem();
        barangayField.removeAllItems(); // Clear old barangays

        if (selectedMunicipality != null && barangayData.containsKey(selectedMunicipality)) {
            for (String brgy : barangayData.get(selectedMunicipality)) {
                barangayField.addItem(brgy);
            }
        }


    }//GEN-LAST:event_saveButtonActionPerformed

    private void houseNumberFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_houseNumberFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_houseNumberFieldActionPerformed

    private void cityFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cityFieldActionPerformed
        String selectedMunicipality = (String) cityField.getSelectedItem();
        barangayField.removeAllItems(); // Clear old barangays

        if (selectedMunicipality != null && barangayData.containsKey(selectedMunicipality)) {
            for (String brgy : barangayData.get(selectedMunicipality)) {
                barangayField.addItem(brgy);
            }
        }
    }//GEN-LAST:event_cityFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> barangayField;
    private javax.swing.JButton cancelButton;
    private javax.swing.JComboBox<String> cityField;
    public javax.swing.JTextField houseNumberField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JTextField provinceField;
    private javax.swing.JButton saveButton;
    public javax.swing.JTextField streetField;
    private javax.swing.JLabel warningLabel;
    public javax.swing.JTextField zipCodeField;
    // End of variables declaration//GEN-END:variables
}
