using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Ball : MonoBehaviour
{

    [SerializeField]
    private float initialVelocity = 3f;

    [SerializeField]
    private GameManager gameManager;

    [SerializeField]
    private AudioSource crash;

    [SerializeField]
    private AudioSource score;


    private Rigidbody2D ballRb;
    private static float collisionpadel = 1f;

    public static float Collisionpadel { get => collisionpadel; set => collisionpadel = value; }

    public static float getcollisionpadel() {  return Collisionpadel; }


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
        score.Play();

        if (collision.gameObject.tag == "Left")
        {
            gameManager.ScorePlayerTwo();
            collisionpadel = 1f;
        }
        else if (collision.gameObject.tag == "Right")
        {
            gameManager.ScorePlayerOne();
            collisionpadel = 1f;
        }

        
    }

    private void OnCollisionEnter2D(Collision2D collision)
    {
        if(collision.gameObject.tag =="Padel1"|| collision.gameObject.tag == "Padel2")
        {
            Collisionpadel += 0.02f;
            ballRb.velocity *= Collisionpadel;
        }

        crash.Play();
    }

}
