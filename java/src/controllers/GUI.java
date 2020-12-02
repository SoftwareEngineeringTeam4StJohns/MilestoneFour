package controllers;


import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

import cloudEntities.Job;
import cloudEntities.Vehicle;
import logging.Loggers;
import logging.vehicleDataBase;
import logging.vehicleDataBase.*;

public class GUI extends JFrame implements Observer{


    
	private static final long serialVersionUID = -6308587216591120597L;
	private boolean clientPermission = false;
	
	public GUI() {
    	this.vcc = VCC.instanceOf();
        initComponents();
        this.addWindowListener(new WindowAdapter() {
		    public void windowClosing(WindowEvent e) {
		    	
		    }
		});
    }
                
    private void initComponents() {
    	
        root = new javax.swing.JPanel();
        focusedPanel = new javax.swing.JPanel();
        ownerPanel = new javax.swing.JPanel();
        welcomeText = new javax.swing.JLabel();
        jobIDLabel = new javax.swing.JLabel();
        jobID = new javax.swing.JTextField();
        approxJobTime = new javax.swing.JLabel();
        approxJobTimeLabel = new javax.swing.JLabel();
        brandName = new javax.swing.JLabel();
        brandLogo = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        submit = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        root.setBackground(new java.awt.Color(34, 40, 44));
        root.setLayout(new java.awt.BorderLayout());

        focusedPanel.setBackground(new java.awt.Color(34, 40, 44));
        focusedPanel.setPreferredSize(new java.awt.Dimension(1153, 582));

        ownerPanel.setBackground(new java.awt.Color(34, 40, 44));

        welcomeText.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        welcomeText.setForeground(new java.awt.Color(204, 204, 204));
        welcomeText.setText("Welcome Back Cloud Contoller...");

        jobIDLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jobIDLabel.setForeground(new java.awt.Color(204, 204, 204));
        jobIDLabel.setText("Specify Job ID:");

        approxJobTime.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        approxJobTime.setForeground(new java.awt.Color(204, 204, 204));
        approxJobTime.setText("");

        approxJobTimeLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        approxJobTimeLabel.setForeground(new java.awt.Color(204, 204, 204));
        approxJobTimeLabel.setText("Estimated Job Time:");

        brandName.setFont(new java.awt.Font("Sitka Banner", 2, 48)); // NOI18N
        brandName.setForeground(new java.awt.Color(204, 204, 204));
        brandName.setText("Icarus Vehicle Cloud Services");

        brandLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/static/icons/cloud.png"))); // NOI18N
        brandLogo.setDoubleBuffered(true);

        submit.setBackground(new java.awt.Color(51, 51, 51));
        submit.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        submit.setForeground(new java.awt.Color(0, 0, 51));
        submit.setText("Generate Time");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ownerPanelLayout = new javax.swing.GroupLayout(ownerPanel);
        ownerPanel.setLayout(ownerPanelLayout);
        ownerPanelLayout.setHorizontalGroup(
            ownerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ownerPanelLayout.createSequentialGroup()
                .addGap(168, 168, 168)
                .addGroup(ownerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ownerPanelLayout.createSequentialGroup()
                        .addGroup(ownerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(brandName)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 519, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(169, 169, 169)
                        .addComponent(brandLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(welcomeText)
                    .addGroup(ownerPanelLayout.createSequentialGroup()
                        .addGroup(ownerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jobIDLabel)
                            .addComponent(approxJobTimeLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ownerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(approxJobTime)
                            .addGroup(ownerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(submit, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                                .addComponent(jobID, javax.swing.GroupLayout.Alignment.LEADING)))))
                .addContainerGap(249, Short.MAX_VALUE))
        );
        ownerPanelLayout.setVerticalGroup(
            ownerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ownerPanelLayout.createSequentialGroup()
                .addContainerGap(68, Short.MAX_VALUE)
                .addGroup(ownerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(brandLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ownerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(brandName, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, 38)
                .addComponent(welcomeText, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(134, 134, 134)
                .addGroup(ownerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jobID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jobIDLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(32, 32, 32)
                .addComponent(submit, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addGroup(ownerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(approxJobTimeLabel)
                    .addComponent(approxJobTime))
                .addGap(225, 225, 225))
        );

        javax.swing.GroupLayout focusedPanelLayout = new javax.swing.GroupLayout(focusedPanel);
        focusedPanel.setLayout(focusedPanelLayout);
        focusedPanelLayout.setHorizontalGroup(
            focusedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ownerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        focusedPanelLayout.setVerticalGroup(
            focusedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ownerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        root.add(focusedPanel, java.awt.BorderLayout.LINE_END);

        getContentPane().add(root, java.awt.BorderLayout.LINE_START);
        getContentPane().add(jSeparator2, java.awt.BorderLayout.CENTER);

        pack();
    }                       

    private void submitActionPerformed(java.awt.event.ActionEvent evt) { 
    	//Eventually we will need to see if the entry exists within system 
		if (!(jobID.getText().isEmpty())) {
			approxJobTime.setText(vcc.getJobCompletion(jobID.getText()));
		}
				
    }
    
    public void clearApproxTime() {
		approxJobTime.setText("Time has expired. Please search another");
	}
    
    
    /*
     * This class is implemented as an observer. Once an update is made within the client-side GUI, 
     * this GUI (VCC/server-side) will be notified and determine which pop-up window to display. 
     */
	public void update(Job job, users.GUI clientGui) {
		//pop-window for job yes/no
		int answer = JOptionPane.showConfirmDialog(focusedPanel, "Accept Job ID: "+job.getID()+"?", "Accept Job?", JOptionPane.YES_NO_CANCEL_OPTION);
		clientGui.answeredVehicleRequest(answer);
		if(answer == 0) {
			vcc.registerJob(job);
			Loggers.logJob(job);
		}
	}

	/*
	 * Based on the yes/no from the VCC, display the pop-up showing the result 
	 * to the client by simply...
	 * clientGui.answerRequest(response)
	 */
	public void update(Vehicle vehicle, users.GUI clientGui) {
		int answer = JOptionPane.showConfirmDialog(focusedPanel, "Accept Vehicle ID: "+vehicle.getID()+"?", "Accept Vehicle?", JOptionPane.YES_NO_CANCEL_OPTION);
		clientGui.answeredVehicleRequest(answer);
		if(answer == 0) {
			vcc.registerVehicle(vehicle);
			Loggers.logVehicle(vehicle);
			vehicleDataBase.connect(vehicle);
		}
	}
   
    
    private VCC vcc;
    private javax.swing.JLabel approxJobTime;
    private javax.swing.JLabel approxJobTimeLabel;
    private javax.swing.JLabel brandLogo;
    private javax.swing.JLabel brandName;
    private javax.swing.JPanel focusedPanel;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField jobID;
    private javax.swing.JLabel jobIDLabel;
    private javax.swing.JPanel ownerPanel;
    private javax.swing.JPanel root;
    private javax.swing.JButton submit;
    private javax.swing.JLabel welcomeText;

	
    
	
	

	

}



