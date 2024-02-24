# -*- coding: utf-8 -*-

from odoo import models, fields, api


class coche(models.Model):
    _name = 'modulo.coche'

    marca = fields.Char(
        string='Marca',
        store=True,
        readonly=False,
        required=True,
        translate=False)
    
    modelo = fields.Char(
        string='Modelo',
        store=True,
        readonly=False,
        required=True,
        translate=False)
    
    name = fields.Char(
        string='Matricula',
        store=True,
        readonly=False,
        required=True,
        translate=False)
    
    color = fields.Selection(selection=[('1','Rojo'),('2','Azul'),('3','Verde')],
        string='Color',
        store=True,
        readonly=False,
        required=True,
        translate=False)
    
    
    # value = fields.Integer()
    # value2 = fields.Float(compute="_value_pc", store=True)
    # description = fields.Text()

    # @api.depends('value')
    # def _value_pc(self):
    #     for record in self:
    #         record.value2 = float(record.value) / 100


class averia(models.Model):
    _name = 'modulo.averia'

    coche = fields.Many2one('modulo.coche',
        string='coche',
        store=True,
        readonly=False,
        required=True,
        translate=False)
    
    fecha= fields.Date(string='Fecha', 
        default=fields.Datetime.now,
        store=True,
        readonly=False,
        required=True,
        translate=False)
    
    precio = fields.Float(
        string='Precio',
        store=True,
        readonly=False,
        required=True,
        translate=False)
    
    tipo = fields.Char(
        string='Tipo',
        store=True,
        readonly=False,
        required=True,
        translate=False)



    
