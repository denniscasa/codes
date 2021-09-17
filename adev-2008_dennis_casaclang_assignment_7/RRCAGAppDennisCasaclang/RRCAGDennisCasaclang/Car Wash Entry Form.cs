/*
* Name: Dennis Casaclang
* Program: Business Information Technology
* Course: ADEV-2008 Programming 2
* Created: 2021-03-26
* Updated: 2021-03-26
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
using Casaclang.Dennis.Business;

namespace RRCAGDennisCasaclang
{
    public partial class Car_Wash_Entry_Form : Form
    {
        public BindingSource bindingSource;
        private BindingSource sourcePackage;
        private BindingSource sourceFragrance;
        private BindingSource sourceInterior;
        private BindingSource sourceExterior;
        private BindingList<string> interiorValue;
        private BindingList<string> exteriorValue;
        private CarWashInvoice invoice;
        public Car_Wash_Entry_Form()
        {
            InitializeComponent();

            this.Load += Car_Wash_Entry_Form_Load;


            bindingSource = new BindingSource();
            sourcePackage = new BindingSource();
            sourceFragrance = new BindingSource();
            sourceInterior = new BindingSource();
            sourceExterior = new BindingSource();
            interiorValue = new BindingList<string>();
            exteriorValue = new BindingList<string>();

            exitToolStripMenuItem.Click += ExitToolStripMenuItem_Click;
            cBoxPackage.SelectedIndexChanged += CBoxPackage_SelectedIndexChanged;
            cBoxFragrance.SelectedIndexChanged += CBoxFragrance_SelectedIndexChanged;
            generateInvoiceToolStripMenuItem.Click += GenerateInvoiceToolStripMenuItem_Click;
        }

        private void Car_Wash_Entry_Form_Load(object sender, EventArgs e)
        {
            FileStream stream = new FileStream("fragrances.txt", FileMode.Open, FileAccess.Read);
            StreamReader reader = new StreamReader(stream);
            string[] newLine = new string[0];
            string[] packageList = {"Standard", "Deluxe", "Executive", "Luxury" };
            List<string> fragranceList = new List<string>();

            while (reader.Peek() != -1)
            {
                newLine = reader.ReadLine().Split(',');
                fragranceList.Add(newLine[0]);
            }

            reader.Close();
            stream.Dispose();

            sourcePackage.DataSource = packageList;
            cBoxPackage.DataSource = sourcePackage;

            sourceFragrance.DataSource = fragranceList;
            cBoxFragrance.DataSource = sourceFragrance;

            cBoxFragrance.SelectedIndex = 0;
            cBoxPackage.SelectedIndex = 0;
        }

        private void GenerateInvoiceToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Car_Wash_Invoice_Form carWashInvoice = new Car_Wash_Invoice_Form(bindingSource);
            carWashInvoice.ShowDialog();
        }

        private void updateInput()
        {
            int index = cBoxPackage.SelectedIndex;
            interiorValue.Clear();
            exteriorValue.Clear();
            string shampooCarpets = "Shampoo Carpet";
            string shampooUpholstery = "Shampoo Upholstery";
            string interiorCoat = "Interior Protection Coat";
            string handWash = "Hand Wash";
            string handWax = "Hand Wax";
            string wheelPolish = "Wheel Polish";
            string detailCompartment = "Detail Engine Compartment";


            switch (index)
            {
                case 0:
                    interiorValue.Insert(0, $"Fragrance - {cBoxFragrance.SelectedItem}");
                    exteriorValue.Add(handWash);
                    break;
                case 1:
                    interiorValue.Insert(0, $"Fragrance - {cBoxFragrance.SelectedItem}");
                    interiorValue.Add(shampooCarpets);
                    exteriorValue.Add(handWash);
                    exteriorValue.Add(handWax);
                    break;
                case 2:
                    interiorValue.Insert(0, $"Fragrance - {cBoxFragrance.SelectedItem}");
                    interiorValue.Add(shampooCarpets);
                    interiorValue.Add(shampooUpholstery);
                    exteriorValue.Add(handWash);
                    exteriorValue.Add(handWax);
                    exteriorValue.Add(wheelPolish);
                    break;
                case 3:
                    interiorValue.Insert(0, $"Fragrance - {cBoxFragrance.SelectedItem}");
                    interiorValue.Add(shampooCarpets);
                    interiorValue.Add(shampooUpholstery);
                    interiorValue.Add(interiorCoat);
                    exteriorValue.Add(handWash);
                    exteriorValue.Add(handWax);
                    exteriorValue.Add(wheelPolish);
                    exteriorValue.Add(detailCompartment);
                    break;
            }

            sourceInterior.DataSource = interiorValue;
            sourceExterior.DataSource = exteriorValue;
            this.lstBoxExterior.DataSource = sourceExterior;
            this.lstBoxInterior.DataSource = sourceInterior;
        }
        private void CBoxFragrance_SelectedIndexChanged(object sender, EventArgs e)
        {
            //this.cBoxPackage.DataSource = this.sourcePackage;
           // this.cBoxFragrance.DataSource = this.sourceFragrance;
            this.updateInput();
            this.updatePrice();
        }

        private void CBoxPackage_SelectedIndexChanged(object sender, EventArgs e)
        {
            //this.cBoxPackage.DataSource = this.sourcePackage;
            //this.cBoxFragrance.DataSource = this.sourceFragrance;
        }

        private void clearBindings()
        {
            txtSubtotal.DataBindings.Clear();
            txtGST.DataBindings.Clear();
            txtPST.DataBindings.Clear();
            txtTotal.DataBindings.Clear();
        }

        private void updatePrice()
        {
            int packageIndex = cBoxPackage.SelectedIndex;
            int fragranceIndex = cBoxFragrance.SelectedIndex;
            decimal provincialRate = .10M;
            decimal gstRate = .15M;
            decimal packageCost = 0;
            decimal fragranceCost = 0;
            
            switch(packageIndex)
            {
                case 0:
                    packageCost = 7.5M;
                    break;
                case 1:
                    packageCost = 15M;
                    break;
                case 2:
                    packageCost = 35M;
                    break;
                case 3:
                    packageCost = 55M;
                    break;
            }

            switch(fragranceIndex)
            {
                case 0:
                    fragranceCost = 0;
                    break;
                case 1:
                    fragranceCost = 2.75M;
                    break;
                case 2:
                    fragranceCost = 1.5M;
                    break;
                case 3:
                    fragranceCost = 2.25M;
                    break;
                case 4:
                    fragranceCost = .75M;
                    break;
                case 5:
                    fragranceCost = 2M;
                    break;
            }

            this.invoice = new CarWashInvoice(provincialRate, gstRate, packageCost, fragranceCost);
            this.bindingSource.DataSource = invoice;
            Binding subtotal = new Binding("Text", bindingSource, "Subtotal", true, DataSourceUpdateMode.Never, "", "C2");
            Binding PST = new Binding("Text", bindingSource, "ProvincialSalesTaxCharged", true, DataSourceUpdateMode.Never, "", "N2");
            Binding GST = new Binding("Text", bindingSource, "GoodsAndServicesTaxCharged", true, DataSourceUpdateMode.Never, "", "N2");
            Binding total = new Binding("Text", bindingSource, "Total", true, DataSourceUpdateMode.Never, "", "C2");

            clearBindings();
            this.txtSubtotal.DataBindings.Add(subtotal);
            this.txtGST.DataBindings.Add(GST);
            this.txtPST.DataBindings.Add(PST);
            this.txtTotal.DataBindings.Add(total);
        }

        private void ExitToolStripMenuItem_Click(object sender, EventArgs e)
        {
            this.Close();
        }

    }
}
