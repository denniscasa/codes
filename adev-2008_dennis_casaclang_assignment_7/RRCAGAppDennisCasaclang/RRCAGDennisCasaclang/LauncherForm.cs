/*
* Name: Dennis Casaclang
* Program: Business Information Technology
* Course: ADEV-2008 Programming 2
* Created: 2021-03-13
* Updated: 2021-03-17
*/

using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.IO;

namespace RRCAGDennisCasaclang
{
    public partial class LauncherForm : Form
    {
        public LauncherForm()
        {
            InitializeComponent();

            salesQuoteToolStripMenuItem.Click += SalesQuoteToolStripMenuItem_Click;
            exitToolStripMenuItem.Click += ExitToolStripMenuItem_Click;
            aboutToolStripMenuItem.Click += AboutToolStripMenuItem_Click;
            vehicleToolStripMenuItem.Click += VehicleToolStripMenuItem_Click;
        }

        private void VehicleToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Vehicle_Data_Form vehicle_Data_Form = new Vehicle_Data_Form();
            vehicle_Data_Form.Show();
        }

        private void AboutToolStripMenuItem_Click(object sender, EventArgs e)
        {
            About_Form aboutForm = new About_Form();
            aboutForm.ShowDialog();
        }

        private void ExitToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void SalesQuoteToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Sales_Quote_Form salesQuoteForm = new Sales_Quote_Form();
            salesQuoteForm.Show();
        }

        private void vehicleToolStripMenuItem_Click(object sender, EventArgs e)
        {

        }

        private void carWashToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Car_Wash_Entry_Form carWashEntryForm = new Car_Wash_Entry_Form();

            FileStream stream;

            try
            {
                stream = new FileStream("fragrances.txt", FileMode.Open, FileAccess.Read);

                Car_Wash_Entry_Form newForm = new Car_Wash_Entry_Form();
                newForm.Show();

                stream.Dispose();
            }
            catch (FileNotFoundException)
            {
                MessageBoxDefaultButton defaultBtn = MessageBoxDefaultButton.Button1;
                MessageBoxButtons button = MessageBoxButtons.OK;
                MessageBoxIcon icon = MessageBoxIcon.Error;
                string message = "Fragrances data file not found.";
                string caption = "Data File Error";
                DialogResult result;

                result = MessageBox.Show(message, caption, button, icon, defaultBtn);

                if (result == System.Windows.Forms.DialogResult.OK)
                {
                    carWashEntryForm.Dispose();
                }
            }
        }
    }
}
