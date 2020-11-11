package users;

import javax.swing.*;

import controllers.VCC;
import logging.Loggers;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;


public class GUI extends JFrame implements ActionListener {
	
	
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -9194071616675269563L;
	private void initComponents() {
        root = new JPanel();
        sideNavigation = new JPanel();
        homeNavButton = new JButton();
        clientNavButton = new JButton();
        ownerNavButton = new JButton();
        helpButton = new JButton();
        focusedPanel = new JPanel();
        homePanel = new JPanel();
        legendLabel = new JLabel();
        homeLegLabel = new JLabel();
        clientLegLabel = new JLabel();
        ownerLegLabel = new JLabel();
        helpLegLabel = new JLabel();
        brandName = new JLabel();
        brandLogo = new JLabel();
        introSynopsis = new JLabel();
        Home1 = new JButton();
        Client1 = new JButton();
        Owner1 = new JButton();
        Help = new JButton();
        jSeparator1 = new JSeparator();
        brandLogo = new JLabel();
        jSeparator2 = new JSeparator();
        clientPanel = new JPanel();
        clientIDLabel = new JLabel();
        clientID = new JTextField();
        jobInfoLabel = new JLabel();
        jobInfo = new TextArea();
        jobTypeLabel  = new JLabel();
        jobType = new JComboBox<>();
        approxTimeLabel = new JLabel();
        hourLabel = new JLabel();
        minuteLabel = new JLabel();
        deadlineLabel = new JLabel();
        approxJobHours = new JComboBox<>();
        approxJobMin = new JComboBox<>();
        deadlineHours = new JComboBox<>();
        deadlineMin = new JComboBox<>();
        clientSubmit = new JButton();
        ownerPanel = new JPanel();
        ownerIDLabel = new JLabel();
        ownerID = new JTextField();
        vehModelLabel = new JLabel();
        vehModel = new JTextField();
        vehPlateLabel = new JLabel();
        vehPlate = new JTextField();
        vehColorLabel = new JLabel();
        vehColor = new JComboBox<>();
        compSpec = new JComboBox<>();
        compSpecLabel = new JLabel();
        approxResLabel = new JLabel();
        approxMonsLabel = new JLabel();
        approxMons = new JComboBox<>();
        approxDaysLabel = new JLabel();
        approxDays = new JComboBox<>();
        ownerSubmit = new JButton();
        // the new DISPOSE_ON_CLOSE method will allow us to exit one window without closing the program
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); 

        root.setBackground(new java.awt.Color(34, 40, 44));
        root.setLayout(new java.awt.BorderLayout());
        
        sideNavigation.setBackground(new java.awt.Color(21, 25, 28));
        sideNavigation.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        sideNavigation.setPreferredSize(new java.awt.Dimension(80, 0));
        sideNavigation.setRequestFocusEnabled(false);

        homeNavButton.setBackground(new java.awt.Color(34, 40, 44));
        homeNavButton.setForeground(new java.awt.Color(250, 0, 0));
        homeNavButton.setIcon(new ImageIcon(getClass().getResource("/static/icons/icons8_home_100px.png"))); // NOI18N
        homeNavButton.setPreferredSize(new java.awt.Dimension(60, 60));
        homeNavButton.setActionCommand("HOME");
        homeNavButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                homeNavButtonActionPerformed(evt);
            }
        });
        homeNavButton.addActionListener(this);
        sideNavigation.add(homeNavButton);

        clientNavButton.setBackground(new java.awt.Color(34, 40, 44));
        clientNavButton.setForeground(new java.awt.Color(250, 0, 0));
        clientNavButton.setIcon(new ImageIcon(getClass().getResource("/static/icons/icons8_person_70px_1.png"))); // NOI18N
        clientNavButton.setPreferredSize(new java.awt.Dimension(60, 60));
        clientNavButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        clientNavButton.setActionCommand("CLIENT");
        clientNavButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                clientNavButtonActionPerformed(evt);
            }
        });
        clientNavButton.addActionListener(this);
        sideNavigation.add(clientNavButton);

        ownerNavButton.setBackground(new java.awt.Color(34, 40, 44));
        ownerNavButton.setForeground(new java.awt.Color(250, 0, 0));
        ownerNavButton.setIcon(new ImageIcon(getClass().getResource("/static/icons/icons8_car_70px.png"))); // NOI18N
        ownerNavButton.setPreferredSize(new java.awt.Dimension(60, 60));
        ownerNavButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        ownerNavButton.setActionCommand("OWNER");
        ownerNavButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ownerNavButtonActionPerformed(evt);
            }
        });
        ownerNavButton.addActionListener(this);
        sideNavigation.add(ownerNavButton);

        helpButton.setBackground(new java.awt.Color(34, 40, 44));
        helpButton.setForeground(new java.awt.Color(250, 0, 0));
        helpButton.setIcon(new ImageIcon(getClass().getResource("/static/icons/icons8_help_70px.png"))); // NOI18N
        helpButton.setPreferredSize(new java.awt.Dimension(60, 60));
        helpButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                helpButtonActionPerformed(evt);
            }
        });
        sideNavigation.add(helpButton);

        root.add(sideNavigation, java.awt.BorderLayout.LINE_START);
        
        focusedPanel.setBackground(new java.awt.Color(34, 40, 44));
        focusedPanel.setPreferredSize(new java.awt.Dimension(1153, 582));
        focusedPanel.setLayout(new java.awt.CardLayout());
        
        homePanel.setBackground(new java.awt.Color(34, 40, 44));
        homePanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        legendLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        legendLabel.setForeground(new java.awt.Color(204, 204, 204));
        legendLabel.setText("Legend:");

        brandName.setFont(new java.awt.Font("Sitka Banner", 2, 48)); // NOI18N
        brandName.setForeground(new java.awt.Color(204, 204, 204));
        brandName.setText("Icarus Vehicle Cloud Services");

        homeLegLabel.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        homeLegLabel.setForeground(new java.awt.Color(204, 204, 204));
        homeLegLabel.setLabelFor(Home1);
        homeLegLabel.setText("Home (current)");
        
        Home1.setBackground(new java.awt.Color(34, 40, 44));
        Home1.setForeground(new java.awt.Color(250, 0, 0));
        Home1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/static/icons/icons8_home_100px.png"))); // NOI18N
        Home1.setPreferredSize(new java.awt.Dimension(60, 60));
        Home1.setActionCommand("HOME");
        Home1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Home1ActionPerformed(evt);
            }
        });
        Home1.addActionListener(this);

        clientLegLabel.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        clientLegLabel.setForeground(new java.awt.Color(204, 204, 204));
        clientLegLabel.setText("Client");
        
        Client1.setBackground(new java.awt.Color(34, 40, 44));
        Client1.setForeground(new java.awt.Color(250, 0, 0));
        Client1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/static/icons/icons8_person_70px_1.png"))); // NOI18N
        Client1.setPreferredSize(new java.awt.Dimension(60, 60));
        Client1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Client1.setActionCommand("CLIENT");
        Client1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Client1ActionPerformed(evt);
            }
        });
        Client1.addActionListener(this);

        ownerLegLabel.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        ownerLegLabel.setForeground(new java.awt.Color(204, 204, 204));
        ownerLegLabel.setText("Vehicle owner");

        Owner1.setBackground(new java.awt.Color(34, 40, 44));
        Owner1.setForeground(new java.awt.Color(250, 0, 0));
        Owner1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/static/icons/icons8_car_70px.png"))); // NOI18N
        Owner1.setPreferredSize(new java.awt.Dimension(60, 60));
        Owner1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Owner1.setActionCommand("OWNER");
        Owner1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Owner1ActionPerformed(evt);
            }
        });
        Owner1.addActionListener(this);
        
        helpLegLabel.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        helpLegLabel.setForeground(new java.awt.Color(204, 204, 204));
        helpLegLabel.setText("Help");
        
        Help.setBackground(new java.awt.Color(34, 40, 44));
        Help.setForeground(new java.awt.Color(250, 0, 0));
        Help.setIcon(new ImageIcon(getClass().getResource("/static/icons/icons8_help_70px.png"))); // NOI18N
        Help.setPreferredSize(new java.awt.Dimension(60, 60));
        Help.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	helpButtonActionPerformed(evt);
            }
        });
        Help.addActionListener(this);
        
        
        brandLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/static/icons/cloud.png"))); // NOI18N
        brandLogo.setDoubleBuffered(true);
        
        introSynopsis.setForeground(new java.awt.Color(204, 204, 204));
        introSynopsis.setText("<html>\n<h4>\nWelcome to our vehicle cloud service program!  \n</h4>\n<span>For all vehicle owners seeking to enroll in our service, please see the Vehicle Owner Page.</span>\n<br>\n<br>\n<span>For all clients interested in contracting a job, please see the Client page. </span>\n<br>\n<br>\n<span>We're pleased to be working in the clouds...</span>\n</html>\n");
        introSynopsis.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        
        
       GroupLayout homePanelLayout = new javax.swing.GroupLayout(homePanel);
        homePanel.setLayout(homePanelLayout);
        homePanelLayout.setHorizontalGroup(
                homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(homePanelLayout.createSequentialGroup()
                    .addGap(140, 140, 140)
                    .addGroup(homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(homePanelLayout.createSequentialGroup()
                            .addGroup(homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(homePanelLayout.createSequentialGroup()
                                    .addComponent(Home1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(Client1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addGroup(homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(homePanelLayout.createSequentialGroup()
                                            .addComponent(ownerLegLabel)
                                            .addGap(41, 41, 41)
                                            .addComponent(helpLegLabel))
                                        .addGroup(homePanelLayout.createSequentialGroup()
                                            .addComponent(Owner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(Help, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(homePanelLayout.createSequentialGroup()
                                    .addComponent(homeLegLabel)
                                    .addGap(32, 32, 32)
                                    .addComponent(clientLegLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(legendLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(16, 16, 16))
                        .addGroup(homePanelLayout.createSequentialGroup()
                            .addGroup(homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(homePanelLayout.createSequentialGroup()
                                    .addGroup(homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(brandName))
                                    .addGap(112, 112, 112))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, homePanelLayout.createSequentialGroup()
                                    .addComponent(introSynopsis, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                            .addComponent(brandLogo)))
                    .addGap(0, 108, Short.MAX_VALUE))
            );
            homePanelLayout.setVerticalGroup(
                homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(homePanelLayout.createSequentialGroup()
                    .addGap(109, 109, 109)
                    .addGroup(homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(homePanelLayout.createSequentialGroup()
                            .addComponent(brandLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 208, Short.MAX_VALUE)
                            .addComponent(legendLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(4, 4, 4)
                            .addGroup(homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(clientLegLabel)
                                .addComponent(homeLegLabel)
                                .addComponent(ownerLegLabel)
                                .addComponent(helpLegLabel))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Home1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Client1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Owner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Help, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(43, 43, 43))
                        .addGroup(homePanelLayout.createSequentialGroup()
                            .addGroup(homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(homePanelLayout.createSequentialGroup()
                                    .addComponent(brandName, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(66, 66, 66)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(introSynopsis, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            );

        focusedPanel.add(homePanel, "HOME");
      
        clientPanel.setBackground(new java.awt.Color(34, 40, 44));
        clientIDLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        clientIDLabel.setForeground(new java.awt.Color(204, 204, 204));
        clientIDLabel.setText("Job ID:");

        jobInfoLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jobInfoLabel.setForeground(new java.awt.Color(204, 204, 204));
        jobInfoLabel.setText("Job Info");

        approxTimeLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        approxTimeLabel.setForeground(new java.awt.Color(204, 204, 204));
        approxTimeLabel.setText("Estimated Job Time");
        approxTimeLabel.setPreferredSize(new java.awt.Dimension(130, 29));

        hourLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        hourLabel.setForeground(new java.awt.Color(204, 204, 204));
        hourLabel.setText("Hours");
        hourLabel.setPreferredSize(new java.awt.Dimension(130, 29));

        minuteLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        minuteLabel.setForeground(new java.awt.Color(204, 204, 204));
        minuteLabel.setText("Minutes");
        minuteLabel.setPreferredSize(new java.awt.Dimension(130, 29));

        deadlineLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        deadlineLabel.setForeground(new java.awt.Color(204, 204, 204));
        deadlineLabel.setText("Deadline");
        deadlineLabel.setPreferredSize(new java.awt.Dimension(130, 29));

        approxJobHours.setModel(new DefaultComboBoxModel<>(new String[] { "Select" }));
        approxJobHours.setSelectedItem(approxJobHours);

        approxJobMin.setModel(new DefaultComboBoxModel<>(new String[] { "Select" }));
        approxJobMin.setSelectedItem(approxJobMin);

        deadlineHours.setModel(new DefaultComboBoxModel<>(new String[] { "Select" }));
        deadlineHours.setSelectedItem(deadlineHours);

        deadlineMin.setModel(new DefaultComboBoxModel<>(new String[] { "Select" }));
        deadlineMin.setSelectedItem(deadlineMin);
        
        jobType.setModel(new DefaultComboBoxModel<>(new String[] { "Select" }));
        jobType.setSelectedItem(jobType);

        jobTypeLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jobTypeLabel.setForeground(new java.awt.Color(204, 204, 204));
        jobTypeLabel.setText("Job Type");
        
        
        clientSubmit.setBackground(new java.awt.Color(34, 40, 44));
        clientSubmit.setForeground(new java.awt.Color(250, 0, 0));
        clientSubmit.setIcon(new ImageIcon(getClass().getResource("/static/icons/icons8_submit_for_approval_100px_1.png"))); // NOI18N
        clientSubmit.setOpaque(false);
        clientSubmit.setPreferredSize(new java.awt.Dimension(60, 60));
        clientSubmit.setVerticalTextPosition(SwingConstants.BOTTOM);
        clientSubmit.setActionCommand("HOME");
        clientSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                clientSubmitActionPerformed(evt);
            }
        });
        clientSubmit.addActionListener(this);

        GroupLayout clientPanelLayout = new GroupLayout(clientPanel);
        clientPanel.setLayout(clientPanelLayout);
        clientPanelLayout.setHorizontalGroup(
                clientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(clientPanelLayout.createSequentialGroup()
                    .addGap(165, 165, 165)
                    .addGroup(clientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(clientPanelLayout.createSequentialGroup()
                            .addGroup(clientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(approxTimeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(deadlineLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(clientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(clientPanelLayout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(approxJobHours, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(clientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(clientPanelLayout.createSequentialGroup()
                                            .addGap(19, 19, 19)
                                            .addComponent(minuteLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(clientPanelLayout.createSequentialGroup()
                                            .addGap(18, 18, 18)
                                            .addComponent(approxJobMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(clientPanelLayout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addComponent(deadlineHours, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(deadlineMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(clientPanelLayout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addGroup(clientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jobType, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(hourLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGroup(clientPanelLayout.createSequentialGroup()
                            .addGroup(clientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(clientIDLabel)
                                .addComponent(jobInfoLabel)
                                .addComponent(jobTypeLabel))
                            .addGap(80, 80, 80)
                            .addGroup(clientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(clientID, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jobInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addContainerGap(565, Short.MAX_VALUE))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, clientPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(clientSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(222, 222, 222))
            );
            clientPanelLayout.setVerticalGroup(
                clientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, clientPanelLayout.createSequentialGroup()
                    .addGap(34, 34, 34)
                    .addGroup(clientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(clientIDLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(clientID, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(54, 54, 54)
                    .addGroup(clientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jobInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jobInfoLabel))
                    .addGap(58, 58, 58)
                    .addGroup(clientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jobTypeLabel)
                        .addComponent(jobType, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(26, 26, 26)
                    .addGroup(clientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(minuteLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(hourLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(3, 3, 3)
                    .addGroup(clientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(approxTimeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(approxJobMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(approxJobHours, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(39, 39, 39)
                    .addGroup(clientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(deadlineLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(deadlineHours, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(deadlineMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(33, 33, 33)
                    .addComponent(clientSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(25, 25, 25))
            );
        generateComboBoxVals(approxJobHours, deadlineHours, approxJobMin, deadlineMin);

        focusedPanel.add(clientPanel, "CLIENT");

        
        ownerPanel.setBackground(new java.awt.Color(34, 40, 44));
        ownerIDLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        ownerIDLabel.setForeground(new java.awt.Color(204, 204, 204));
        ownerIDLabel.setText("Owner ID:");

        vehModelLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        vehModelLabel.setForeground(new java.awt.Color(204, 204, 204));
        vehModelLabel.setText("Vehicle Model:");

        vehPlateLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        vehPlateLabel.setForeground(new java.awt.Color(204, 204, 204));
        vehPlateLabel.setText("Vehicle Plate#:");

        vehColorLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        vehColorLabel.setForeground(new java.awt.Color(204, 204, 204));
        vehColorLabel.setText("Color:");

        vehColor.setModel(new DefaultComboBoxModel<>(new String[] { "Select" }));

        approxResLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        approxResLabel.setForeground(new java.awt.Color(204, 204, 204));
        approxResLabel.setText("Approx. Residency");

        approxMonsLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        approxMonsLabel.setForeground(new java.awt.Color(204, 204, 204));
        approxMonsLabel.setText("Months");

        approxMons.setModel(new DefaultComboBoxModel<>(new String[] { "Select" }));

        approxDaysLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        approxDaysLabel.setForeground(new java.awt.Color(204, 204, 204));
        approxDaysLabel.setText("Days");

        approxDays.setModel(new DefaultComboBoxModel<>(new String[] { "Select" }));
        
        compSpecLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        compSpecLabel.setForeground(new java.awt.Color(204, 204, 204));
        compSpecLabel.setText("Computation Spec.");
        
        compSpec.setModel(new DefaultComboBoxModel<>(new String[] { "Select" }));
        
        
        ownerSubmit.setBackground(new java.awt.Color(34, 40, 44));
        ownerSubmit.setForeground(new java.awt.Color(250, 0, 0));
        ownerSubmit.setIcon(new ImageIcon(getClass().getResource("/static/icons/icons8_submit_for_approval_100px_1.png"))); // NOI18N
        ownerSubmit.setOpaque(false);
        ownerSubmit.setPreferredSize(new java.awt.Dimension(60, 60));
        ownerSubmit.setVerticalTextPosition(SwingConstants.BOTTOM);
        ownerSubmit.setActionCommand("HOME");
        ownerSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ownerSubmitActionPerformed(evt);
            }
        });
        ownerSubmit.addActionListener(this);

        GroupLayout ownerPanelLayout = new GroupLayout(ownerPanel);
        ownerPanel.setLayout(ownerPanelLayout);
        ownerPanelLayout.setHorizontalGroup(
                ownerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ownerPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(ownerSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(183, 183, 183))
                .addGroup(ownerPanelLayout.createSequentialGroup()
                    .addGap(140, 140, 140)
                    .addGroup(ownerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(ownerPanelLayout.createSequentialGroup()
                            .addComponent(approxResLabel)
                            .addGap(28, 28, 28)
                            .addGroup(ownerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(approxMons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(approxMonsLabel))
                            .addGap(30, 30, 30)
                            .addGroup(ownerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(approxDaysLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(approxDays, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(ownerPanelLayout.createSequentialGroup()
                            .addGroup(ownerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(vehModelLabel)
                                .addComponent(ownerIDLabel)
                                .addComponent(vehPlateLabel)
                                .addComponent(compSpecLabel)
                                .addComponent(vehColorLabel))
                            .addGap(87, 87, 87)
                            .addGroup(ownerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(vehModel)
                                .addComponent(vehPlate, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                                .addComponent(ownerID)
                                .addComponent(vehColor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(compSpec, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addContainerGap(561, Short.MAX_VALUE))
            );
            ownerPanelLayout.setVerticalGroup(
                ownerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ownerPanelLayout.createSequentialGroup()
                    .addGroup(ownerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(ownerPanelLayout.createSequentialGroup()
                            .addGroup(ownerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ownerPanelLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(ownerIDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(115, 115, 115))
                                .addGroup(ownerPanelLayout.createSequentialGroup()
                                    .addGap(116, 116, 116)
                                    .addComponent(vehModelLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(41, 41, 41)))
                            .addGroup(ownerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(vehPlateLabel)
                                .addComponent(vehPlate, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(ownerPanelLayout.createSequentialGroup()
                            .addGap(122, 122, 122)
                            .addComponent(vehModel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(ownerPanelLayout.createSequentialGroup()
                            .addGap(50, 50, 50)
                            .addComponent(ownerID, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(35, 35, 35)
                    .addGroup(ownerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(compSpecLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(compSpec, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(42, 42, 42)
                    .addGroup(ownerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(vehColor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(vehColorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                    .addGroup(ownerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(approxMonsLabel)
                        .addComponent(approxDaysLabel))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(ownerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(approxMons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(approxDays, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(approxResLabel))
                    .addGap(22, 22, 22)
                    .addComponent(ownerSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(40, 40, 40))
            );
        generateComboBoxVals(vehColor,approxDays, approxMons);
        focusedPanel.add(ownerPanel, "OWNER");
        
        root.add(focusedPanel, java.awt.BorderLayout.LINE_END);
        getContentPane().add(root, java.awt.BorderLayout.LINE_START);
        //setting card layout for switching windows
        cl = (CardLayout)(focusedPanel.getLayout());
        pack();
    }                   

	
	private void helpButtonActionPerformed(ActionEvent evt) {                                           
		String message = "Select Client or Owner.\nSelect client if you want to submit a job.\n"
				+ "Select owner if you want to rent out your vehicle.";
		JOptionPane.showMessageDialog(focusedPanel, message);
	}                                          

	private void ownerNavButtonActionPerformed(ActionEvent evt) {                                               
		cl.show(focusedPanel, (String)evt.getActionCommand());
	}                                              

	private void Home1ActionPerformed(ActionEvent evt) {                                      
		cl.show(focusedPanel, (String)evt.getActionCommand());
	}                                     

	private void Client1ActionPerformed(ActionEvent evt) {                                        
		cl.show(focusedPanel, (String)evt.getActionCommand());
	}                                       

	private void Owner1ActionPerformed(ActionEvent evt) {                                       
		cl.show(focusedPanel, (String)evt.getActionCommand());
	}                                      
	
	    
	private void clientNavButtonActionPerformed(ActionEvent evt) {                                                
		cl.show(focusedPanel, (String)evt.getActionCommand());
	}                                               

	private void homeNavButtonActionPerformed(ActionEvent evt) {    
		cl.show(focusedPanel, (String)evt.getActionCommand());
	    clearInfo();
	}                                             
	    
	
	private void clientSubmitActionPerformed(ActionEvent evt) {   
		HashMap<String, String> jobEntry = new HashMap<>();
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		jobEntry.put("ID", clientID.getText());
		jobEntry.put("jobInfo", jobInfo.getText());
		jobEntry.put("approxHours", (String)approxJobHours.getSelectedItem());
		jobEntry.put("approxMin", (String)approxJobMin.getSelectedItem());
		jobEntry.put("deadlineHours", (String)deadlineHours.getSelectedItem());
		jobEntry.put("deadlineMin", (String)deadlineMin.getSelectedItem());
		jobEntry.put("timestamp", timeStamp);
		// an array will be initialized with all of the job info to make it easier on the creation of logs
		Loggers.logJob(jobEntry);
		vcc.registerJob(jobEntry);
		clearInfo();
		cl.show(focusedPanel, (String)evt.getActionCommand());
    }
	    
	    
	private void ownerSubmitActionPerformed(ActionEvent evt) {                            
		HashMap<String, String> vehicleEntry = new HashMap<>();
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		vehicleEntry.put("ID", ownerID.getText());
		vehicleEntry.put("model", vehModel.getText());
		vehicleEntry.put("color", (String)vehColor.getSelectedItem());
		vehicleEntry.put("plate", vehPlate.getText());
		vehicleEntry.put("approxDays", (String)approxDays.getSelectedItem());
		vehicleEntry.put("approxMons", (String)approxMons.getSelectedItem());
		vehicleEntry.put("timestamp", timeStamp);
		System.out.println("Success!");
		//resets information for next use
		vcc.registerVehicle(vehicleEntry);
		Loggers.logVehicle(vehicleEntry);
		clearInfo();
		cl.show(focusedPanel, (String)evt.getActionCommand());
	}                                           
	
	/*
	 * This function is implemented through the ActionListener interface and 
	 * will handle swapping jPanels through the card layout made implemented in the 
	 * focused content panel, for now
	 */
	
	@Override
	public void actionPerformed(ActionEvent event) {
		CardLayout cl = (CardLayout)(focusedPanel.getLayout());
	    cl.show(focusedPanel, (String)event.getActionCommand());
	}

	/*
	 * The constructor of the main GUI panel. 
	 */
	public GUI(logging.Monitor monitor) {
		this.setTitle("Client Window");
		this.monitor = monitor;
		vcc = VCC.instanceOf();
		initComponents();
		//deprecated use of generating logs on window close 
		this.addWindowListener(new WindowAdapter() {
		    public void windowClosing(WindowEvent e) {
		    }
		});
	}
	
	
	/*
	 * Handles clearing information after each entry
	 */
	private void clearInfo() {
		//client info clear
		clientID.setText(null);
		jobInfo.setText(null);
		approxJobHours.setSelectedIndex(0);
		approxJobMin.setSelectedIndex(0);
		deadlineHours.setSelectedIndex(0);
		deadlineMin.setSelectedIndex(0);
		
		//owner info clear
		ownerID.setText(null);
		vehModel.setText(null);
		vehPlate.setText(null);
		vehColor.setSelectedIndex(0);
		approxDays.setSelectedIndex(0);
		approxMons.setSelectedIndex(0);
	}

	
	/*
	 * Functions to automate the generation of integer dependent combo box values. 
	 */
	private void generateComboBoxVals(JComboBox<String> vehColorBox, JComboBox<String> approxDays, JComboBox<String> approxMons) {
		for(int i=0; i<colors.length; i++) {
			vehColorBox.addItem(colors[i]);
		}
		
		for (int i = 0; i <= 30; i++) {
			approxDays.addItem(Integer.toString(i));
		}

		for (int i = 0; i <= 24; i++) {
			approxMons.addItem(Integer.toString(i));
		}
	}

	private void generateComboBoxVals(JComboBox<String> approxJobHours, JComboBox<String> deadlineHours, JComboBox<String> approxJobMin,
			JComboBox<String> deadlineMin) {
		for (int i = 0; i <= 48; i++) {
			approxJobHours.addItem(Integer.toString(i));
			deadlineHours.addItem(Integer.toString(i));
		}
		for (int i = 0; i <= 59; i++) {
			approxJobMin.addItem(Integer.toString(i));
			deadlineMin.addItem(Integer.toString(i));
		}
	}

	
	
	
    private JButton Client1;
    private JButton Help;
    private JButton Home1;
    private JButton Owner1;
    private JComboBox<String> approxDays;
    private JLabel approxDaysLabel;
    private JComboBox<String> approxJobHours;
    private JComboBox<String> approxJobMin;
    private JComboBox<String> approxMons;
    private JLabel approxMonsLabel;
    private JLabel approxResLabel;
    private JLabel approxTimeLabel;
    private JTextField clientID;
    private JLabel clientIDLabel;
    private JLabel clientLegLabel;
    private JButton clientNavButton;
    private JPanel clientPanel;
    private JButton clientSubmit;
    private JComboBox<String> deadlineHours;
    private JLabel deadlineLabel;
    private JComboBox<String> deadlineMin;
    private JPanel focusedPanel;
    private JLabel homeLegLabel;
    private JLabel helpLegLabel;
    private JButton helpButton;
    private JButton homeNavButton;
    private JPanel homePanel;
    private JLabel hourLabel;
    private JLabel legendLabel;
    private JLabel brandLogo;
    private JLabel brandName;
    private JLabel introSynopsis;
    private JSeparator jSeparator1;
    private JSeparator jSeparator2;
    private TextArea jobInfo;
    private JLabel jobInfoLabel;
    private JComboBox<String> jobType;
    private JLabel jobTypeLabel;
    private JLabel minuteLabel;
    private JTextField ownerID;
    private JLabel ownerIDLabel;
    private JLabel ownerLegLabel;
    private JButton ownerNavButton;
    private JPanel ownerPanel;
    private JButton ownerSubmit;
    private JPanel root;
    private JPanel sideNavigation;
    private JComboBox<String> vehColor;
    private JLabel vehColorLabel;
    private JTextField vehModel;
    private JLabel vehModelLabel;
    private JTextField vehPlate;
    private JLabel vehPlateLabel;
    private JComboBox<String> compSpec;
    private JLabel compSpecLabel;
    private CardLayout cl;
    private String[] colors= {"White", "Black", "Grey", "Silver", "Green", "Red", "Blue", "Yellow", "Purple", "Pink", "Orange", "Other"};
	private VCC vcc;
	logging.Monitor monitor;
    // End of variables declaration                  


	
	
}
