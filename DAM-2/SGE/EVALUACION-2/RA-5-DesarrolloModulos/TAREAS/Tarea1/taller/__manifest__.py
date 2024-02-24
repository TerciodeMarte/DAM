# -*- coding: utf-8 -*-
{
    'name': "taller",

    'summary': """Modulo para gestionar un taller de reparacion de vehiculos""",

    'description': 
        """ Este módulo es una solución completa para gestionar un taller de reparación de vehículos que se especializa en la gestión de averías. 
        Proporciona todas las herramientas necesarias para registrar y administrar las averías de los vehículos, asignar técnicos a las reparaciones, 
        realizar un seguimiento del progreso de las reparaciones y generar informes detallados sobre las averías y los trabajos realizados.
        Con este módulo, los talleres pueden optimizar su proceso de reparación, mejorar la eficiencia y brindar un mejor servicio a sus clientes."""
    ,

    'author': "Albano Diez",
    'website': "https://github.com/CafeConPalito",

    # Categories can be used to filter modules in modules listing
    # Check https://github.com/odoo/odoo/blob/16.0/odoo/addons/base/data/ir_module_category_data.xml
    # for the full list
    'category': 'Sales',
    'version': '1.0.1',

    # any module necessary for this one to work correctly
    'depends': ['base'],

    # always loaded
    'data': [
        # 'security/ir.model.access.csv',
        'views/views.xml'
        # 'views/templates.xml',
    ]
    # only loaded in demonstration mode
    # 'demo': [
    #     'demo/demo.xml',
    # ],
}
