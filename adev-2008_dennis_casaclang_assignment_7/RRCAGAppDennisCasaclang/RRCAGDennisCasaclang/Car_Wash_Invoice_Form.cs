using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace RRCAGDennisCasaclang
{
    public partial class Car_Wash_Invoice_Form : Form
    {
        private BindingSource source;
        public Car_Wash_Invoice_Form(BindingSource bindingSource)
        {
            InitializeComponent();
            source = bindingSource;
            this.Text = "Car Wash Invoice";
            lblCompany.Text = "RRC Automotive Group";
            lblAddress.Text = "777 Inheritance Drive";
            lblCityProvincePostal.Text = "Winnipeg, MB I0I 0I0";
            lblPhone.Text = "204-867-5309";
            lblDate.Text = DateTime.Now.ToString("MM/dd/yyyy");

            Binding fragranceCost = new Binding("Text", source, "FragranceCost", true, DataSourceUpdateMode.Never, "", "N2");
            Binding packageCost = new Binding("Text", source, "PackageCost", true, DataSourceUpdateMode.Never, "", "C2");
            Binding subtotal = new Binding("Text", source, "Subtotal", true, DataSourceUpdateMode.Never, "", "C2");
            Binding GST = new Binding("Text", source, "GoodsAndServicesTaxCharged", true, DataSourceUpdateMode.Never, "", "N2");
            Binding total = new Binding("Text", source, "Total", true, DataSourceUpdateMode.Never, "", "C2");


            this.lblPackage.DataBindings.Add(packageCost);
            this.lblFragrance.DataBindings.Add(fragranceCost);
            this.lblSubtotal.DataBindings.Add(subtotal);
            this.lblTaxes.DataBindings.Add(GST);
            this.lblTotal.DataBindings.Add(total);

        }

    }
}
