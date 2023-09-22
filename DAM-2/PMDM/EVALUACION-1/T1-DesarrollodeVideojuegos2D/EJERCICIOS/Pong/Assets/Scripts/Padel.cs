using System;
using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Padel : MonoBehaviour
{
    [SerializeField]
    private float speed = 7f;
    [SerializeField]
    private bool isPaddle1=false;

    private float yLimit = 3.6f;

    // Update is called once per frame
    void Update()
    {
        float movement;
        if (isPaddle1)
        {
            movement = Input.GetAxisRaw("Vertical");
        }
        else
        {
            movement = Input.GetAxisRaw("Vertical2");
           
        }
        //transform.position += new Vector3(0, movement * speed * Time.deltaTime, 0);
        Vector2 paddlePosition = transform.position;
        paddlePosition.y = Math.Clamp(paddlePosition.y + movement * speed * Time.deltaTime, -yLimit, yLimit);
        transform.position = paddlePosition;
    }
}
