using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Ball : MonoBehaviour
{

    [SerializeField]
    private float initialVelocity = 3f;

    [SerializeField]
    private GameManager gameManager;


    private Rigidbody2D ballRb;
    private static float collisionpadel = 1f;

    public static float getcollisionpadel() {  return collisionpadel; }

    public void Launch()
    {
        ballRb = GetComponent<Rigidbody2D>();
        float xVelocity = 0;
        float yVelocity = 0;
        if(Random.Range(0, 2) == 0)
        {
            xVelocity = 1;
        }
        else
        {
            xVelocity = -1;
        }

        if(Random.Range(0, 2) == 0)
        {
            yVelocity = 1;
        }
        else{
            yVelocity = -1;
        }

        ballRb.velocity= new Vector2(xVelocity,yVelocity)*initialVelocity;
       
    }
    private void OnTriggerEnter2D(Collider2D collision)
    {
        if (collision.gameObject.tag == "Left")
        {
            gameManager.ScorePlayerOne();
        }
        else if (collision.gameObject.tag == "Right")
        {
            gameManager.ScorePlayerTwo();
        }
    }

    private void OnCollisionEnter2D(Collision2D collision)
    {
        if(collision.gameObject.tag =="Padel1"|| collision.gameObject.tag == "Padel2")
        {
            collisionpadel += 0.02f;
            ballRb.velocity *= collisionpadel;
        }
    }

}
