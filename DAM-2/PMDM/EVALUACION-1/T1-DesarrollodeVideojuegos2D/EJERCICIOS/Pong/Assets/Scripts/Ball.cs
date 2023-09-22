using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Ball : MonoBehaviour
{
    private Rigidbody2D ballRb;

    [SerializeField]
    private float initialVelocity = 3f;
    // Start is called before the first frame update
    void Start()
    {
        ballRb= GetComponent<Rigidbody2D>();
        Launch();
    }

    private void Launch()
    {
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

    void OnCollisionEnter2D(Collision2D col)
    {
        
        if (col.gameObject.tag == "Left")
        {
            StartCoroutine("point",true);
        }
        else if(col.gameObject.tag == "Right")
        {
            StartCoroutine("point", false);
        }
    }

    IEnumerator point(bool isLeft)
    {
        if (isLeft)
        {
            yield return new WaitForSeconds(.1f);
        }
    }


}
